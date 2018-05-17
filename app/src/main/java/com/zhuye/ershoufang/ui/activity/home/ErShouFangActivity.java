package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.XinFangAdapter;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ErShouFangActivity extends BaseActivity {

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
        return R.layout.activity_er_shou_fang;
    }


    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("二手房");
        subtitle.setVisibility(View.GONE);
        adapter = new XinFangAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //进入新房详情页
                Intent intent = new Intent(ErShouFangActivity.this,ErShouFangDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
    }
}
