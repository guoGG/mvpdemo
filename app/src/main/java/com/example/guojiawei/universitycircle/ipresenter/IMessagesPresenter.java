package com.example.guojiawei.universitycircle.ipresenter;

import com.example.guojiawei.universitycircle.contracts.MessagesContracts;
import com.example.guojiawei.universitycircle.entity.Message;

import java.util.Collections;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by guojiawei on 2017/3/15.
 */

public class IMessagesPresenter implements MessagesContracts.MessagesPresenter {

    private MessagesContracts.MessagesView mView;

    public IMessagesPresenter(MessagesContracts.MessagesView view) {
        this.mView = view;
    }

    @Override
    public void getMessages() {
        BmobQuery<Message> query = new BmobQuery<Message>();
        query.setCachePolicy(BmobQuery.CachePolicy.CACHE_ELSE_NETWORK);    // 先从缓存获取数据，如果没有，再从网络获取。
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<Message>() {
            @Override
            public void done(List<Message> object, BmobException e) {
                if (e == null) {
                    Collections.reverse(object);
                    mView.getMessagesSuccess(object);
                    for (Message gameScore : object) {
                        //获得数据的objectId信息
                        gameScore.getObjectId();
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                        gameScore.getCreatedAt();
                    }
                } else {
                    mView.getMessageFail();
                }
            }
        });
    }
}
