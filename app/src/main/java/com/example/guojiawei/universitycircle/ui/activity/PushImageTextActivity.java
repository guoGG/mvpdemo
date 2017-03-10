package com.example.guojiawei.universitycircle.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.util.GlideUtil;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by guojiawei on 2017/3/8.
 */

public class PushImageTextActivity extends BaseActivity {
    @InjectView(R.id.push_btn_cancle)
    TextView pushBtnCancle;
    @InjectView(R.id.push_btn_push)
    TextView pushBtnPush;
    @InjectView(R.id.push_imagetext_photo_ablum)
    ImageView pushImagetextPhotoAblum;

    @Override
    public void initView() {
        setContentView(R.layout.activity_push_imagetext);
    }

    @Override
    public void bindView() {

    }

    @OnClick({R.id.push_btn_cancle, R.id.push_btn_push, R.id.push_imagetext_photo_ablum})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.push_btn_cancle:
                onBackPressed();
                break;
            case R.id.push_btn_push:
                break;
            case R.id.push_imagetext_photo_ablum:
                startActivityForResult(new Intent(this, PhotoAlbumActivity.class), 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                String imgPath = data.getStringExtra(PhotoAlbumActivity.IMAGE_PATH);
                GlideUtil.loadUrlImage(this, imgPath, pushImagetextPhotoAblum);
            }
        }
    }
}
