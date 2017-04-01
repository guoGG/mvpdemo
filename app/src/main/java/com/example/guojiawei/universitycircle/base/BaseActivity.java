package com.example.guojiawei.universitycircle.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by guojiawei on 2017/3/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private String TAG = this.getClass().getName();

    private Toast mToast;


    public abstract void initView();

    public abstract void bindView();

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        unbinder = ButterKnife.bind(this);
        bindView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void canclActionBar() {
        getWindow().setBackgroundDrawable(null);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
    }

    public void showToast(String toastMessage) {
        if (mToast == null) {
            mToast = new Toast(this);
        } else {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showLog(String logMessage) {
        Log.e(TAG, logMessage);
    }

}
