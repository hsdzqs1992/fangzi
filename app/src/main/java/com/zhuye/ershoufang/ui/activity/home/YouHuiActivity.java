package com.zhuye.ershoufang.ui.activity.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.Common2Adapter;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class YouHuiActivity extends Common2Activity<CommonBean> {


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
    protected int getResId() {
        return R.layout.common;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"优惠活动");
        adapter = new Common2Adapter(R.layout.youhui_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().activity(SharedPreferencesUtil.getInstance().getString("qu_id"),
                1,page,YouHuiActivity.this
                ,LIST);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
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
    protected void onLoadmore() {
        CommonApi.getInstance().activity(SharedPreferencesUtil.getInstance().getString("qu_id"),
                1,++page,YouHuiActivity.this
                ,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().activity(SharedPreferencesUtil.getInstance().getString("qu_id"),
                1,1,YouHuiActivity.this
                ,REFRESHBASE);
    }
}
