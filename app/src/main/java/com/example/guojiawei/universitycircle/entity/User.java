package com.example.guojiawei.universitycircle.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by guojiawei on 2017/3/13.
 */

public class User extends BmobObject {
    private String name;
    private String password;
    private String address;
    private String authCode;

    @Override
    public void setTableName(String tableName) {
        this.setTableName("_user");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
