package com.zhuye.ershoufang.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MePaiMaiAdapter;
import com.zhuye.ershoufang.adapter.me.MyPaiMaiActivity;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WeiTuoMaiActivity extends BaseActivity {
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

//    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    @BindView(R.id.rec)
//    RecyclerView rec;
//    @BindView(R.id.smart)
//    SmartRefreshLayout smart;


    @Override
    protected int getResId() {
        return R.layout.common2;
    }
    MePaiMaiAdapter adapter;
    @Override
    protected void initView() {
         super.initView();
        setText(ttitle,"委托拍卖");
        setText(subtitle,"我的拍卖");
       adapter = new MePaiMaiAdapter(getSupportFragmentManager(),this);
        viewpager.setAdapter(adapter);
        tablayout.setViewPager(viewpager);
    }

    @OnClick({R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                start(MyPaiMaiActivity.class);
                break;
        }
    }


//    @Override
//    protected void initView() {
//        super.initView();
//        MaiFangWEiItemAdapter adapter = new MaiFangWEiItemAdapter(R.layout.me_weiuo_iem, null);
//        rec.setAdapter(adapter);
//        rec.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    @OnClick(R.id.back)
//    public void onViewClicked() {
//        finish();
//    }


}
