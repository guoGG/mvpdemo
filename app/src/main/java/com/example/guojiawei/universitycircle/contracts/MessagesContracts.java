package com.example.guojiawei.universitycircle.contracts;

import android.support.v7.widget.RecyclerView;

import com.example.guojiawei.universitycircle.base.BasePresenter;
import com.example.guojiawei.universitycircle.base.BaseView;
import com.example.guojiawei.universitycircle.entity.Message;

import java.util.List;

/**
 * Created by guojiawei on 2017/3/15.
 */

public class MessagesContracts {
    public interface MessagesView extends BaseView {
        void getMessagesSuccess(List<Message> msgs);

        void getMessageFail();
    }

    public interface MessagesPresenter extends BasePresenter {
        void getMessages();
    }
}
