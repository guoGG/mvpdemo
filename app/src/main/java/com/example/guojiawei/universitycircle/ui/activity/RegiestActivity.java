package com.example.guojiawei.universitycircle.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.contracts.RegiestContracts;
import com.example.guojiawei.universitycircle.ipresenter.IRegiestPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by guojiawei on 2017/3/10.
 */

public class RegiestActivity extends BaseActivity implements RegiestContracts.RegiestView {

    @InjectView(R.id.regiest_et_username)
    AppCompatEditText regiestEtUsername;
    @InjectView(R.id.regiest_rl_name)
    RelativeLayout regiestRlName;
    @InjectView(R.id.regiest_et_authcode)
    AppCompatEditText regiestEtAuthcode;
    @InjectView(R.id.tl_code)
    TextInputLayout tlCode;
    @InjectView(R.id.regiest_btn_getcode)
    TextView regiestBtnGetcode;
    @InjectView(R.id.regiest_rl_code)
    RelativeLayout regiestRlCode;
    @InjectView(R.id.regiest_et_password)
    AppCompatEditText regiestEtPassword;
    @InjectView(R.id.regiest_rl_password)
    RelativeLayout regiestRlPassword;
    @InjectView(R.id.regiest_btn)
    TextView regiestBtn;

    private RegiestContracts.RegiestPresenter mRegiestPresenter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_regiest);
    }

    @Override
    public void bindView() {
        mRegiestPresenter = new IRegiestPresenter(this);
    }

    @OnClick({R.id.regiest_btn_getcode, R.id.regiest_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regiest_btn_getcode:
                if (getUserName() != null) {
                    mRegiestPresenter.sendCode();
                    regiestBtn.setEnabled(false);
                }
                break;
            case R.id.regiest_btn:

                if (getUserName() != null && getPassword() != null && getAuthCode() != null) {
                    mRegiestPresenter.regiest();
                }
                break;
        }
    }

    @Override
    public String getUserName() {
        if (TextUtils.isEmpty(regiestEtUsername.getText().toString())) {
            return null;
        } else {
            return regiestEtUsername.getText().toString();
        }
    }

    @Override
    public String getPassword() {
        if (TextUtils.isEmpty(regiestEtPassword.getText().toString())) {
            return null;
        } else {
            return regiestEtPassword.getText().toString();
        }
    }

    @Override
    public String getAuthCode() {
        if (TextUtils.isEmpty(regiestEtAuthcode.getText().toString())) {
            return null;
        } else {
            return regiestEtAuthcode.getText().toString();
        }
    }

    @Override
    public void regiestSuccess() {
        showToast("注册成功");
    }

    @Override
    public void regiestFail() {
        showToast("注册失败");
    }

    @Override
    public void sendAuthCodeSuccess() {
        showToast("验证码发送成功");
        regiestBtn.setEnabled(true);
    }

    @Override
    public void sendAuthCodeFail() {
        showToast("验证码发送失败");
        regiestBtn.setEnabled(true);
    }
}
