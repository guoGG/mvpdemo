package com.example.guojiawei.universitycircle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.guojiawei.universitycircle.R;
import com.example.guojiawei.universitycircle.base.BaseActivity;
import com.example.guojiawei.universitycircle.ui.activity.PushImageTextActivity;
import com.example.guojiawei.universitycircle.ui.fragment.FragmentMainHome;
import com.example.guojiawei.universitycircle.ui.fragment.FragmentMainMy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guojiawei on 2017/3/7.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_bottom_btn_ic_home)
    ImageView mainBottomBtnIcHome;
    @BindView(R.id.main_bottom_btn_tv_home)
    TextView mainBottomBtnTvHome;
    @BindView(R.id.main_bottom_btn_home)
    LinearLayout mainBottomBtnHome;
    @BindView(R.id.main_bottom_btn_ic_push)
    ImageView mainBottomBtnIcPush;
    @BindView(R.id.main_bottom_btn_push)
    LinearLayout mainBottomBtnPush;
    @BindView(R.id.main_bottom_btn_ic_my)
    ImageView mainBottomBtnIcMy;
    @BindView(R.id.main_bottom_btn_tv_my)
    TextView mainBottomBtnTvMy;
    @BindView(R.id.main_bottom_btn_my)
    LinearLayout mainBottomBtnMy;
    @BindView(R.id.main_bottom)
    LinearLayout mainBottom;
    @BindView(R.id.main_fragment_page_switch)
    FrameLayout mainFragmentPageSwitch;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private FragmentMainHome mMainHomeFragment;
    private FragmentMainMy mMainMyFragment;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void bindView() {
        initFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment_page_switch, mMainHomeFragment, "首页")
                .add(R.id.main_fragment_page_switch, mMainMyFragment, "个人")
                .show(mMainHomeFragment)
                .hide(mMainMyFragment)
                .commit();
    }

    private void initFragment() {
        if (mMainHomeFragment == null) {
            mMainHomeFragment = new FragmentMainHome();
        }
        if (mMainMyFragment == null) {
            mMainMyFragment = new FragmentMainMy();
        }
    }

    @OnClick({R.id.main_bottom_btn_home, R.id.main_bottom_btn_push, R.id.main_bottom_btn_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_bottom_btn_home:
                mainBottomBtnIcHome.setImageDrawable(getResources().getDrawable(R.drawable.main_bottom_essence_press));
                mainBottomBtnTvHome.setTextColor(getResources().getColor(R.color.colorAccent));
                mainBottomBtnIcMy.setImageDrawable(getResources().getDrawable(R.drawable.main_bottom_my_normal));
                mainBottomBtnTvMy.setTextColor(getResources().getColor(R.color.colorGray));
                getSupportFragmentManager().beginTransaction().show(mMainHomeFragment).hide(mMainMyFragment).commit();
                break;
            case R.id.main_bottom_btn_push:
                startActivity(new Intent(this, PushImageTextActivity.class));
                break;
            case R.id.main_bottom_btn_my:
                mainBottomBtnIcHome.setImageDrawable(getResources().getDrawable(R.drawable.main_bottom_essence_normal));
                mainBottomBtnTvHome.setTextColor(getResources().getColor(R.color.colorGray));
                mainBottomBtnIcMy.setImageDrawable(getResources().getDrawable(R.drawable.main_bottom_my_press));
                mainBottomBtnTvMy.setTextColor(getResources().getColor(R.color.colorAccent));
                getSupportFragmentManager().beginTransaction().hide(mMainHomeFragment).show(mMainMyFragment).commit();

                break;
        }
    }

}
