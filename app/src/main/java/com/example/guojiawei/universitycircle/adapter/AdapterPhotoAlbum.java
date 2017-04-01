package com.example.guojiawei.universitycircle.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.util.GlideUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class AdapterPhotoAlbum extends RecyclerView.Adapter {
    private final int CAMERA = 1;
    private final int IMAGE = 2;
    private List<String> mDatas = new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public AdapterPhotoAlbum(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(mContext);
    }
    public List<String> getmDatas() {
        return mDatas;
    }
    public void addItems(List<String> datas) {
        if (mDatas != null) {
            mDatas.clear();
        }
        mDatas.addAll(datas);
        notifyItemInserted(0);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int w = getWindowWidth();
        View itemCamera = inflater.inflate(R.layout.item_photo_album_camera, parent, false);
        View itemImage = inflater.inflate(R.layout.item_photo_album_img, parent, false);
        itemCamera.setLayoutParams(new LinearLayout.LayoutParams(w, w));
        itemImage.setLayoutParams(new LinearLayout.LayoutParams(w, w));
        itemCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecyclerViewItemClickListener != null) {
                    onRecyclerViewItemClickListener.onItemClick(v, (Integer) v.getTag());
                }
            }
        });

        itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRecyclerViewItemClickListener != null) {
                    onRecyclerViewItemClickListener.onItemClick(v, (Integer) v.getTag());
                }
            }
        });
        if (viewType == CAMERA) {
            return new CameraViewHolder(itemCamera);
        }
        if (viewType == IMAGE) {
            return new ImageViewHolder(itemImage);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CameraViewHolder) {
            holder.itemView.setTag(position);
        }
        if (holder instanceof ImageViewHolder) {
            int index = position - 1;
            holder.itemView.setTag(position);
            GlideUtil.loadUrlImage(mContext, mDatas.get(index), ((ImageViewHolder) holder).photoAlbumItemImg);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return CAMERA;
        } else {
            return IMAGE;
        }
    }

    private int getWindowWidth() {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width / 3;
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    static class CameraViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photo_album_item_camera_btn)
        ImageView photoAlbumItemCameraBtn;

        CameraViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.photo_album_item_img)
        ImageView photoAlbumItemImg;
        @BindView(R.id.photo_album_item_img_check)
        AppCompatCheckBox photoAlbumItemImgCheck;

        ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
