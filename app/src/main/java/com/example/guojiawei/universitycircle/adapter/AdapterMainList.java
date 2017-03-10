package com.example.guojiawei.universitycircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class AdapterMainList extends RecyclerView.Adapter {

    private List mData = new ArrayList();
    private Context mContext;
    private LayoutInflater inflater;

    public AdapterMainList(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void addItems(ArrayList datas) {
        this.mData.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_main_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.item_main_list_ic_header)
        ImageView itemMainListIcHeader;
        @InjectView(R.id.item_main_list_tv_name)
        TextView itemMainListTvName;
        @InjectView(R.id.item_main_list_tv_time)
        TextView itemMainListTvTime;
        @InjectView(R.id.item_main_list_tv_content)
        TextView itemMainListTvContent;
        @InjectView(R.id.item_main_list_ic_img)
        ImageView itemMainListIcImg;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
