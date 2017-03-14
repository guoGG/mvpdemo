package com.example.guojiawei.universitycircle.ipresenter;

import com.example.guojiawei.universitycircle.contracts.LoginContracts;
import com.example.guojiawei.universitycircle.entity.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
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
        bmobQuery.addWhereEqualTo("name", mView.getUserName());
        bmobQuery.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getPassword().equals(mView.getPassword())) {
                            mView.loginSuccess();
                        } else {
                            mView.loginFail();
                        }
                    }

                } else {
                    mView.loginFail();
                }
            }
        });
    }

}
