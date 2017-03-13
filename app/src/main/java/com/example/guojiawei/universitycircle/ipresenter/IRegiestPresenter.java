package com.example.guojiawei.universitycircle.ipresenter;

import android.content.Context;
import android.util.Log;

import com.example.guojiawei.universitycircle.contracts.RegiestContracts;
import com.example.guojiawei.universitycircle.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by guojiawei on 2017/3/13.
 */

public class IRegiestPresenter implements RegiestContracts.RegiestPresenter {

    private RegiestContracts.RegiestView mView;

    public IRegiestPresenter(RegiestContracts.RegiestView view) {
        this.mView = view;
    }

    @Override
    public void sendCode() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendTime = format.format(new Date());
        BmobSMS.requestSMS((Context) mView, mView.getUserName(), "注册验证", sendTime, new RequestSMSCodeListener() {

            @Override
            public void done(Integer smsId, BmobException ex) {
                // TODO Auto-generated method stub
                if (ex == null) {//
                    mView.sendAuthCodeSuccess();
                    Log.i("bmob", "短信发送成功，短信id：" + smsId);//用于查询本次短信发送详情
                } else {
                    mView.sendAuthCodeFail();
                    Log.i("bmob", "errorCode = " + ex.getErrorCode() + ",errorMsg = " + ex.getLocalizedMessage());
                }
            }
        });
    }

    @Override
    public void regiest() {
        User user = new User();
        user.setName(mView.getUserName());
        user.setPassword(mView.getPassword());
        user.setAuthCode(mView.getAuthCode());
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, cn.bmob.v3.exception.BmobException e) {
                if(e==null){
                    mView.regiestSuccess();
                }else{
                    mView.regiestFail();
                }
            }
        });
    }
}
