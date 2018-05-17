package com.zhuye.ershoufang.adapter.me;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.ui.activity.me.AddPaiMaiActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MyPaiMaiActivity extends BaseActivity {


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


    Button tiwen;

    @Override
    protected int getResId() {
        return R.layout.activity_wei_tuo_mai2;
    }
    MyPaiMai2Adapter adapter;
    @Override
    protected void initView() {
        super.initView();
        setText(ttitle,"我的拍卖");
        hide(subtitle);

        adapter = new MyPaiMai2Adapter(getSupportFragmentManager(),this);
        viewpager.setAdapter(adapter);
        tablayout.setViewPager(viewpager);

        tiwen = findViewById(R.id.tiwen);
        adapter.getCurrentItem(0).setData();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void initListener() {
        super.initListener();
        tiwen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(AddPaiMaiActivity.class);
            }
        });

        tablayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                adapter.getCurrentItem(position).setData();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
