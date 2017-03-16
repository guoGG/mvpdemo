package com.example.guojiawei.universitycircle.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by guojiawei on 2017/3/15.
 */

public class Message extends BmobObject {
    private User user;
    private String userId;
    private String msgName;
    private String msgImage;
    private String msgContent;

    @Override
    public void setTableName(String tableName) {
        setTableName("messages");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgImage() {
        return msgImage;
    }

    public void setMsgImage(String msgImage) {
        this.msgImage = msgImage;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
