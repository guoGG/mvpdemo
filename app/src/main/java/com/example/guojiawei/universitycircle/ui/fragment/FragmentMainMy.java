package com.example.guojiawei.universitycircle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseFragment;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class FragmentMainMy extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_my, null);
        return rootView;
    }

    @Override
    public void bindView() {

    }
}
