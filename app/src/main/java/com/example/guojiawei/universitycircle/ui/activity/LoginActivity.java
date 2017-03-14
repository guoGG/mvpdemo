package com.example.guojiawei.universitycircle.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.contracts.LoginContracts;
import com.example.guojiawei.universitycircle.ipresenter.ILoginPresenter;
import com.example.guojiawei.universitycircle.ui.MainActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by guojiawei on 2017/3/10.
 */

public class LoginActivity extends BaseActivity implements LoginContracts.LoginView {
    @InjectView(R.id.login_rl_name)
    RelativeLayout loginRlName;
    @InjectView(R.id.login_rl_password)
    RelativeLayout loginRlPassword;
    @InjectView(R.id.login_btn)
    TextView loginBtn;
    @InjectView(R.id.login_btn_forget_pwd)
    TextView loginBtnForgetPwd;
    @InjectView(R.id.login_btn_forget_regiest)
    TextView loginBtnForgetRegiest;
    @InjectView(R.id.login_et_username)
    AppCompatEditText loginEtUsername;
    @InjectView(R.id.login_et_password)
    AppCompatEditText loginEtPassword;

    private LoginContracts.LoginPresenter mLoginPresenter = null;

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_login);
    }

    @Override
    public void bindView() {
        mLoginPresenter = new ILoginPresenter(this);
    }


    @Override
    public String getUserName() {
        if (TextUtils.isEmpty(loginEtUsername.getText().toString())) {
            showToast("请输入用户手机号");
            return null;
        } else {
            return loginEtUsername.getText().toString();
        }

    }

    @Override
    public String getPassword() {
        if (TextUtils.isEmpty(loginEtPassword.getText().toString())) {
            showToast("请输入用户密码");
            return null;
        } else {
            return loginEtPassword.getText().toString();
        }
    }

    @Override
    public void loginSuccess() {
        showToast("登陆成功");
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFail() {
        showToast("登陆失败，请检测输入内容");
    }


    @OnClick({R.id.login_btn, R.id.login_btn_forget_pwd, R.id.login_btn_forget_regiest})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                if (getUserName() != null && getPassword() != null) {
                    mLoginPresenter.login();
                }
                break;
            case R.id.login_btn_forget_pwd:
                break;
            case R.id.login_btn_forget_regiest:
                startActivity(new Intent(this, RegiestActivity.class));
                break;
        }
    }
}
