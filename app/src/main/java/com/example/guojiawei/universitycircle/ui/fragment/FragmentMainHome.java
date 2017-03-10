package com.example.guojiawei.universitycircle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.adapter.AdapterMainList;
import com.example.guojiawei.universitycircle.base.BaseFragment;
import com.example.guojiawei.universitycircle.widget.DividerItemDecoration;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class FragmentMainHome extends BaseFragment {
    @InjectView(R.id.fragment_main_home_recyclerview)
    RecyclerView fragmentMainHomeRecyclerview;

    private View rootView = null;

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_home, null);
        return rootView;
    }

    @Override
    public void bindView() {
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        fragmentMainHomeRecyclerview.setLayoutManager(lm);
        fragmentMainHomeRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        AdapterMainList mainListAdapter = new AdapterMainList(getContext());
        fragmentMainHomeRecyclerview.setAdapter(mainListAdapter);
        ArrayList datas = new ArrayList();
        for (int i = 0; i < 20; i++) {
            datas.add("");
        }
        mainListAdapter.addItems(datas);
    }


}
