package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ZhuangXiuAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class JiaJuActivity extends Common2Activity<ZhuangxiuJiaJuBean> {


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
        setText(ttitle,"家居");
        adapter = new ZhuangXiuAdapter(R.layout.zhuangxiu_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        CommonApi.getInstance().jiaju(page,JiaJuActivity.this,LIST);
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
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
        CommonApi.getInstance().jiaju(++page,JiaJuActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().jiaju(1,JiaJuActivity.this,REFRESHBASE);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(JiaJuActivity.this,ZhuangXiuDetailActivity.class);
                intent.putExtra("id",list.get(position).getUser_id());
                startActivity(intent);
            }
        });
    }
}
