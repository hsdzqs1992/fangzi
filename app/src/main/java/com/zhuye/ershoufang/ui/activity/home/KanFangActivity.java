package com.zhuye.ershoufang.ui.activity.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.KanFangAdapter;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class KanFangActivity extends BaseActivity {

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
        subtitle.setVisibility(View.GONE);
        ttitle.setText("免费看房");
    }


    @Override
    protected void initData() {
        super.initData();
        adapter = new KanFangAdapter(R.layout.kanfang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
