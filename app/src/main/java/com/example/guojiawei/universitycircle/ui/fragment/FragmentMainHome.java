package com.example.guojiawei.universitycircle.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.adapter.AdapterMainList;
import com.example.guojiawei.universitycircle.base.BaseFragment;
import com.example.guojiawei.universitycircle.contracts.MessagesContracts;
import com.example.guojiawei.universitycircle.entity.Message;
import com.example.guojiawei.universitycircle.ipresenter.IMessagesPresenter;
import com.example.guojiawei.universitycircle.widget.DividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class FragmentMainHome extends BaseFragment implements MessagesContracts.MessagesView {


    @BindView(R.id.fragment_main_home_recyclerview)
    RecyclerView fragmentMainHomeRecyclerview;
    @BindView(R.id.swiprefresh)
    SwipeRefreshLayout swiprefresh;
    private View rootView = null;
    private AdapterMainList mainListAdapter = null;
    private MessagesContracts.MessagesPresenter mMessagesView;

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
        mainListAdapter = new AdapterMainList(getContext());
        fragmentMainHomeRecyclerview.setAdapter(mainListAdapter);
        mMessagesView = new IMessagesPresenter(this);
        mMessagesView.getMessages();
        swiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mMessagesView.getMessages();
            }
        });
    }


    @Override
    public void getMessagesSuccess(List<Message> msgs) {
        mainListAdapter.refreshItems(msgs);
        swiprefresh.setRefreshing(false);
    }

    @Override
    public void getMessageFail() {

    }


}
