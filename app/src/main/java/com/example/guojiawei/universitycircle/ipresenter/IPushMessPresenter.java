package com.example.guojiawei.universitycircle.ipresenter;

import android.text.TextUtils;

import com.example.guojiawei.universitycircle.contracts.PushMessageContracts;
import com.example.guojiawei.universitycircle.entity.Message;
import com.example.guojiawei.universitycircle.entity.User;

import java.io.File;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

/**
 * Created by guojiawei on 2017/3/14.
 */

public class IPushMessPresenter implements PushMessageContracts.PushMessagePresenter {

    private PushMessageContracts.PushMessageView mView;

    public IPushMessPresenter(PushMessageContracts.PushMessageView view) {
        this.mView = view;
    }

    @Override
    public void pushMess() {
        if (TextUtils.isEmpty(mView.getPushImagePath())) {
            return;
        } else {
            uploadImg();

        }
    }

    private void push(String imgPath) {
        Message msg = new Message();
        msg.setMsgContent(mView.getPushMess());
        msg.setMsgImage(imgPath);
        msg.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    mView.pushSuccess();
                } else {
                    mView.pushFail();
                }
            }
        });
    }

    private void uploadImg() {
        String picPath = mView.getPushImagePath();
        final String[] uploadPath = {""};
        final BmobFile bmobFile = new BmobFile(new File(picPath));
        bmobFile.uploadblock(new UploadFileListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    //bmobFile.getFileUrl()--返回的上传文件的完整地址
                    uploadPath[0] = bmobFile.getFileUrl().toString();
                    push(uploadPath[0]);
                } else {

                }

            }

            @Override
            public void onProgress(Integer value) {
                // 返回的上传进度（百分比）
                mView.upLoadImgProgress(value);
            }
        });
    }
}
