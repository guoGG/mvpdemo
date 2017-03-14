package com.example.guojiawei.universitycircle.contracts;

import com.example.guojiawei.universitycircle.base.BasePresenter;
import com.example.guojiawei.universitycircle.base.BaseView;

/**
 * Created by guojiawei on 2017/3/14.
 */

public class PushMessageContracts {
    public interface PushMessageView extends BaseView {
        String getPushMess();

        String getPushImage();

        void pushSuccess();

        void pushFail();
    }

    public interface PushMessagePresenter extends BasePresenter {
        void pushMess();
    }
}
