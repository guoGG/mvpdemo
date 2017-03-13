package com.example.guojiawei.universitycircle.contracts;

import com.example.guojiawei.universitycircle.base.BasePresenter;
import com.example.guojiawei.universitycircle.base.BaseView;

/**
 * Created by guojiawei on 2017/3/13.
 */

public class LoginContracts {
    public interface LoginView extends BaseView {
        String getUserName();

        String getPassword();

        void loginSuccess();

        void loginFail();
    }

    public interface LoginPresenter extends BasePresenter {
        void login();
    }
}
