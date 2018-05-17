package com.zhuye.ershoufang.ui.fragment.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomeXuQiu3Adapter;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class XuQiu3Fragment extends CommonFragment {
    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {

    }

    @Override
    protected void onRefresh() {

    }

    @Override
    protected void initView() {
        adapte = new HomeXuQiu3Adapter(0);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
}
