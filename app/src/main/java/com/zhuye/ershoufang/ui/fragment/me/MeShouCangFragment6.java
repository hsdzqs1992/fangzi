package com.zhuye.ershoufang.ui.fragment.me;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ZhuangXiuAdapter;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MeShouCangFragment6 extends CommonFragment{
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;
    @Override
    public BaseQuickAdapter getAdapter() {
        return null;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().shop_collect(getToken(),++page,2,MeShouCangFragment6.this, LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().shop_collect(getToken(),1,2,MeShouCangFragment6.this, REFRESHBASE);
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().shop_collect(getToken(),page,2,MeShouCangFragment6.this, LIST);
    }

    @Override
    protected void initView() {
        adapte = new ZhuangXiuAdapter(R.layout.zhuangxiu_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }
}
