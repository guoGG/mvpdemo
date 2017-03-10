package com.example.guojiawei.universitycircle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by guojiawei on 2017/3/7.
 */

public abstract class BaseFragment extends Fragment {
    private String TAG = this.getClass().getName();

    private Toast mToast;

    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public abstract void bindView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        bindView();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void showToast(String toastMessage) {
        if (mToast == null) {
            mToast = new Toast(getContext());
        } else {
            mToast.cancel();
        }
        mToast = Toast.makeText(getContext(), toastMessage, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showLog(String logMessage) {
        Log.e(TAG, logMessage);
    }
}
