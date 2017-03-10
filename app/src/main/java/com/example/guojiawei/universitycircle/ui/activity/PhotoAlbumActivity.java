package com.example.guojiawei.universitycircle.ui.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.adapter.AdapterPhotoAlbum;
import com.example.guojiawei.universitycircle.adapter.OnRecyclerViewItemClickListener;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.widget.DividerGridItemDecoration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class PhotoAlbumActivity extends BaseActivity {
    @InjectView(R.id.photo_album_recyclerview)
    RecyclerView photoAlbumRecyclerview;
    public static String IMAGE_PATH = "imagepath";
    private List<String> mImgPaths = null;
    private Uri photoUri;

    @Override
    public void initView() {
        setContentView(R.layout.activity_photo_album);
        queryLocalImages();
    }

    @Override
    public void bindView() {
        bindGridView();
    }

    private void bindGridView() {
        GridLayoutManager gm = new GridLayoutManager(this, 3);
        photoAlbumRecyclerview.setLayoutManager(gm);
        photoAlbumRecyclerview.addItemDecoration(new DividerGridItemDecoration(this));
        final AdapterPhotoAlbum photoAlbumAdapter = new AdapterPhotoAlbum(this);
        photoAlbumRecyclerview.setAdapter(photoAlbumAdapter);
        photoAlbumAdapter.addItems(mImgPaths);

        photoAlbumAdapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (position == 0) {
                    startCamera();
                } else {
                    setResult(1, new Intent().putExtra(IMAGE_PATH, photoAlbumAdapter.getmDatas().get(position-1
                    )));
                    finish();
                }
            }
        });
    }

    private void startCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                "yyyy_MM_dd_HH_mm_ss");
        String filename = timeStampFormat.format(new Date());
        ContentValues values = new ContentValues();
        values.put(MediaStore.Audio.Media.TITLE, filename);
        photoUri = getContentResolver().insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(intent, 0);

    }

    private void queryLocalImages() {
        mImgPaths = new ArrayList<>();
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            //获取图片的名称
            String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
            //获取图片的生成日期
            byte[] data = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            //获取图片的详细信息
            String desc = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION));
            //获取图片路径
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            //将查询的图片路径加入集合
            mImgPaths.add(path);
        }
        cursor.close();

    }

    private String queryCameraImage(Uri uri) {
        String path = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(
                uri, proj, null, null, null);
        while (cursor.moveToNext()) {
            //获取图片路径
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            path = cursor.getString(column_index);
        }
        return path;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                Uri uri = data.getData();
                String imgPath = queryCameraImage(photoUri);
                setResult(1, new Intent().putExtra(IMAGE_PATH, imgPath));
                finish();
            } else {
                if (photoUri != null) {
                    String imgPath = queryCameraImage(photoUri);
                    setResult(1, new Intent().putExtra(IMAGE_PATH, imgPath));
                    finish();
                }
            }

        }
    }


}
