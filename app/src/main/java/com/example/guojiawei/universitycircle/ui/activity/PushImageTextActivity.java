package com.example.guojiawei.universitycircle.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.contracts.PushMessageContracts;
import com.example.guojiawei.universitycircle.ipresenter.IPushMessPresenter;
import com.example.guojiawei.universitycircle.util.GlideUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guojiawei on 2017/3/8.
 */

public class PushImageTextActivity extends BaseActivity implements PushMessageContracts.PushMessageView {

    @BindView(R.id.push_btn_cancle)
    TextView pushBtnCancle;
    @BindView(R.id.push_btn_push)
    TextView pushBtnPush;
    @BindView(R.id.push_et_content)
    AppCompatEditText pushEtContent;
    @BindView(R.id.push_imagetext_photo_ablum)
    ImageView pushImagetextPhotoAblum;
    private String imgPath = null;
    private PushMessageContracts.PushMessagePresenter mPushMessagePresenter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_push_imagetext);
    }

    @Override
    public void bindView() {
        mPushMessagePresenter = new IPushMessPresenter(this);
    }

    @OnClick({R.id.push_btn_cancle, R.id.push_btn_push, R.id.push_imagetext_photo_ablum})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.push_btn_cancle:
                onBackPressed();
                break;
            case R.id.push_btn_push:
                mPushMessagePresenter.pushMess();
                pushBtnPush.setEnabled(false);
                break;
            case R.id.push_imagetext_photo_ablum:
                startActivityForResult(new Intent(this, PhotoAlbumActivity.class), 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                imgPath = data.getStringExtra(PhotoAlbumActivity.IMAGE_PATH);
                GlideUtil.loadUrlImage(this, imgPath, pushImagetextPhotoAblum);
            }
        }
    }

    @Override
    public String getPushMess() {
        if (TextUtils.isEmpty(pushEtContent.getText().toString().trim())) {
            return null;
        } else {
            return pushEtContent.getText().toString().trim();
        }
    }

    @Override
    public String getPushImagePath() {
        if (TextUtils.isEmpty(imgPath)) {
            return null;
        } else {
            return imgPath;
        }

    }

    @Override
    public void upLoadImgProgress(int value) {
        showLog(value + "");
    }

    @Override
    public void pushSuccess() {
        showToast("发布成功");
        onBackPressed();
    }

    @Override
    public void pushFail() {
        showToast("发布失败");
        pushBtnPush.setEnabled(true);
    }

}
