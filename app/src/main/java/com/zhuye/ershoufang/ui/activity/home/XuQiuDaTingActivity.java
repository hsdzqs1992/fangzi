package com.zhuye.ershoufang.ui.activity.home;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.XuQiuDaTingAdapter;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class XuQiuDaTingActivity extends BaseActivity {


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
        return R.layout.common3;
    }

    @Override
    protected void initView() {
        super.initView();
        subtitle.setVisibility(View.GONE);
        ttitle.setText("需求大厅");


    }

    @Override
    protected void initData() {
        super.initData();
        XuQiuDaTingAdapter adapter1 = new XuQiuDaTingAdapter(getSupportFragmentManager(), this, R.array.home_xuqiudating);
        viewpager.setAdapter(adapter1);
        tablayout.setViewPager(viewpager);

    }



    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
