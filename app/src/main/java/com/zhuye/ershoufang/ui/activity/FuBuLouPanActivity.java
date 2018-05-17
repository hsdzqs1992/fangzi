package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.FaBuLouPanAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.LouPanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.ui.activity.home.EditLouPanActivity;
import com.zhuye.ershoufang.ui.activity.me.AddLouPanActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class FuBuLouPanActivity extends Common2Activity<LouPanBean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.xinzeng)
    Button xinzeng;

    @Override
    protected int getResId() {
        return R.layout.activity_fu_bu_lou_pan;
    }

    @Override
    protected void initView() {
        super.initView();
        subtitle.setVisibility(View.INVISIBLE);
        ttitle.setText("发布楼盘");
        adapter = new FaBuLouPanAdapter(R.layout.me_fabuloupan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        CommonApi.getInstance().newhouse_list(getToken(),page,FuBuLouPanActivity.this,LIST);
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
    }

    @OnClick({R.id.back, R.id.xinzeng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinzeng:
                start(AddLouPanActivity.class);
                break;
        }
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
        CommonApi.getInstance().newhouse_list(getToken(),++page,FuBuLouPanActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().newhouse_list(getToken(),1,FuBuLouPanActivity.this,REFRESHBASE);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.zhiding:
                        break;
                    case R.id.edit:
                        Intent intent = new Intent(FuBuLouPanActivity.this, EditLouPanActivity.class);
                        intent.putExtra("id",list.get(position).getId());
                        startActivity(intent);
                        break;
                }
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }
}
