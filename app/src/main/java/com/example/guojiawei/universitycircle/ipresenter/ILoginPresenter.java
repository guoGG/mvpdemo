package com.example.guojiawei.universitycircle.ipresenter;

import com.example.guojiawei.universitycircle.contracts.LoginContracts;
import com.example.guojiawei.universitycircle.entity.User;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by guojiawei on 2017/3/13.
 */

public class ILoginPresenter implements LoginContracts.LoginPresenter {

    private LoginContracts.LoginView mView;

    public ILoginPresenter(LoginContracts.LoginView view) {
        this.mView = view;
    }

    @Override
    public void login() {
        BmobQuery<User> bmobQuery = new BmobQuery<User>();
        bmobQuery.getObject(mView.getUserName(), new QueryListener<User>() {
            @Override
            public void done(User object, BmobException e) {
                if (e == null) {
                    if (object.getPassword().equals(mView.getPassword())) {
                        mView.loginSuccess();
                    } else {
                        mView.loginFail();
                    }
                } else {
                    mView.loginFail();
                }
            }
        });
    }

}
