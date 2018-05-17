package com.zhuye.ershoufang.ui.activity.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

public class GongYechangFangActivity extends Common2Activity<CommonBean> {

    @Override
    protected int getResId() {
        return R.layout.activity_gong_yechang_fang;
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return null;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return null;
    }

    @Override
    protected void onLoadmore() {

    }

    @Override
    protected void onRefresh() {

    }
}
