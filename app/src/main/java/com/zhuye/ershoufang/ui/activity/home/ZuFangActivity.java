package com.zhuye.ershoufang.ui.activity.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ZuFangAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;

import butterknife.BindView;
import butterknife.OnClick;

public class ZuFangActivity extends CommonHome2Activity<Common3Bean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.smartferesh)
    SmartRefreshLayout smartferesh;
    @BindView(R.id.quyu)
    LinearLayout quyu;
    @BindView(R.id.jiage)
    LinearLayout jiage;
    @BindView(R.id.jinjiren)
    LinearLayout jinjiren;

    @Override
    protected int getResId() {
        return R.layout.activity_zu_fang;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "租房");
        adapter = new ZuFangAdapter(R.layout.home_zufang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @OnClick({R.id.back, R.id.quyu, R.id.jiage, R.id.jinjiren})
    public void onViewClicked(View view) {
        dat.clear();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.quyu:
                clickJieDao(view);
                break;
            case R.id.jiage:
                alertjiageWindow(view,100);
                break;
            case R.id.jinjiren:
                dat.add("个人");
                dat.add("经纪人");
                alertWindow(view, dat, 12);
                break;
        }
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return smartferesh;
    }

    @Override
    protected void onLoadmore() {

    }

    @Override
    protected void onRefresh() {

    }
}

