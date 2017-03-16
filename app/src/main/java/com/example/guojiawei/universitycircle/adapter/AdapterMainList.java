package com.example.guojiawei.universitycircle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.entity.Message;
import com.example.guojiawei.universitycircle.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class AdapterMainList extends RecyclerView.Adapter {

    private List<Message> mData = new ArrayList();
    private Context mContext;
    private LayoutInflater inflater;

    public AdapterMainList(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void addItems(List<Message> datas) {
        this.mData.addAll(datas);
        notifyDataSetChanged();
    }

    public void refreshItems(List<Message> datas) {
        this.mData.clear();
        this.mData.addAll(datas);
        notifyItemChanged(0);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_main_list, parent, false);
        return new MainItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainItemViewHolder h = (MainItemViewHolder) holder;
        GlideUtil.loadUrlImage(mContext, mData.get(position).getMsgImage(), h.itemMainListIcImg);
        h.itemMainListTvContent.setText(mData.get(position).getMsgContent());
        h.itemMainListTvTime.setText(mData.get(position).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MainItemViewHolder extends RecyclerView.ViewHolder {
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

        MainItemViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
