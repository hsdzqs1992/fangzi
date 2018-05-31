package com.zhuye.ershoufang.ui.activity.home;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomeWendaAdapter;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeWenDaActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.tablayout)
    SmartTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.refresh)
    LinearLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.activity_home_wen_da;
    }

    HomeWendaAdapter adapter;
    @Override
    protected void initView() {
        super.initView();
        adapter = new HomeWendaAdapter(getSupportFragmentManager(),this);
        viewpager.setAdapter(adapter);
        tablayout.setViewPager(viewpager);

        hide(subtitle);
        hide(ttitle);
    }


    @Override
    protected void initListener() {
        super.initListener();
        tablayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                adapter.setData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

}
