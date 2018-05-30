package com.zhuye.ershoufang.ui.activity;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.ShouCangAdapter2;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

//CommonActivity
public class ShouCangActivity extends BaseActivity {

    ShouCangAdapter2 adapter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.tablayout)
    SmartTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void initView() {
        super.initView();
        adapter = new ShouCangAdapter2(getSupportFragmentManager(), this);
//        recycle.setAdapter(adapter);
//        recycle.setLayoutManager(new LinearLayoutManager(this));
//        hide(subtitle);
//        setText(ttitle,"我的收藏");
        hide(subtitle);
        setText(ttitle,"我的收藏");
        viewpager.setAdapter(adapter);
        tablayout.setViewPager(viewpager);


        tablayout.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {

            }
        });
    }

    @Override
    protected int getResId() {
        return R.layout.activity_shou_cang;
    }



    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
