package com.zhuye.ershoufang.ui.activity.common;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class CommonActivity extends BaseActivity {

    @BindView(R.id.back)
    protected ImageView back;
    @BindView(R.id.ttitle)
    protected TextView ttitle;
    @BindView(R.id.subtitle)
    protected TextView subtitle;
    @BindView(R.id.recycle)
    protected RecyclerView recycle;
    @BindView(R.id.refresh)
    protected SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.common;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
