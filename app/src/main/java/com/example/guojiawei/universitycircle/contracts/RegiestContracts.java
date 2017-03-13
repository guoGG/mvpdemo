package com.example.guojiawei.universitycircle.contracts;

import com.example.guojiawei.universitycircle.base.BasePresenter;
import com.example.guojiawei.universitycircle.base.BaseView;

/**
 * Created by guojiawei on 2017/3/13.
 */

public class RegiestContracts {
    public interface RegiestView extends BaseView {
        String getUserName();

        String getPassword();

        String getAuthCode();

        void regiestSuccess();

        void regiestFail();

        void sendAuthCodeSuccess();

        void sendAuthCodeFail();
    }

    public interface RegiestPresenter extends BasePresenter {
        void sendCode();

        void regiest();
    }
}
