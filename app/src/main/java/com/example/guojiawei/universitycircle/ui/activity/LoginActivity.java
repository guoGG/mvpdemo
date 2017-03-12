package com.example.guojiawei.universitycircle.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.ui.MainActivity;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by guojiawei on 2017/3/10.
 */

public class LoginActivity extends BaseActivity {

    @InjectView(R.id.login_name_img)
    ImageView loginNameImg;
    @InjectView(R.id.login_rl_name)
    RelativeLayout loginRlName;
    @InjectView(R.id.login_password_img)
    ImageView loginPasswordImg;
    @InjectView(R.id.login_rl_password)
    RelativeLayout loginRlPassword;
    @InjectView(R.id.login_btn)
    TextView loginBtn;
    @InjectView(R.id.login_btn_forget_pwd)
    TextView loginBtnForgetPwd;
    @InjectView(R.id.login_btn_forget_regiest)
    TextView loginBtnForgetRegiest;

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_login);
    }

    @Override
    public void bindView() {

    }


    @OnClick(R.id.login_btn)
    public void onClick() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
