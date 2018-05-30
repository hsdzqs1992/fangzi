package com.zhuye.ershoufang.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.KanFangJiAdapter;
import com.zhuye.ershoufang.bean.MianKanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class KanFangJiluActivity extends Common2Activity<MianKanBean> {


    KanFangJiAdapter adapter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected void initView() {
        super.initView();
        adapter = new KanFangJiAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        hide(subtitle);
        setText(ttitle, "看房记录");
    }

    @Override
    protected int getResId() {
        return R.layout.common;
    }


    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().mybm(getToken(),page,KanFangJiluActivity.this,LIST);
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().mybm(getToken(),++page,KanFangJiluActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().mybm(getToken(),1,KanFangJiluActivity.this,REFRESHBASE);
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
