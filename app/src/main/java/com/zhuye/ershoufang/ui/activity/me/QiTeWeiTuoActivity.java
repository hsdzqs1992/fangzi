package com.zhuye.ershoufang.ui.activity.me;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.qite.QiTeAdapter;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class QiTeWeiTuoActivity extends BaseActivity {

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
        hide(subtitle);
        setText(ttitle,"其他委托");
        QiTeAdapter adapter  = new QiTeAdapter(getSupportFragmentManager(),this,R.array.me_qite);
        viewpager.setAdapter(adapter);
        tablayout.setViewPager(viewpager);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
