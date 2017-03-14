package com.example.guojiawei.universitycircle;

import android.app.Application;

import cn.bmob.sms.BmobSMS;
import cn.bmob.v3.Bmob;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "0e1d3a7195b876bdf132f72195605df7");

    }
}
