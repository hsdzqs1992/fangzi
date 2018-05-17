package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.XinFangAdapter;
import com.zhuye.ershoufang.bean.Common2Bean;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class XinFangActivity extends Common2Activity<Common2Bean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.smartferesh)
    SmartRefreshLayout smartferesh;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.ll3)
    LinearLayout ll3;

    @Override
    protected int getResId() {
        return R.layout.activity_xin_fang;
    }

    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("新房");
        subtitle.setVisibility(View.GONE);
        adapter = new XinFangAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
    }


    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return smartferesh;
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //进入新房详情页
                Intent intent = new Intent(XinFangActivity.this, XinFangDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onLoadmore() {

    }

    @Override
    protected void onRefresh() {

    }


    @Override
    protected void initData() {
        super.initData();

//        CommonApi.getInstance().indexnewhouse
    }


    @OnClick({R.id.back,R.id.ll1,R.id.ll2,R.id.ll3})
    public void onViewClicked(View view) {
        List<String> dat = new ArrayList<>();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ll1:
                alertWindow(view, dat, 9);
                break;
            case R.id.ll2:
                dat.add("从高到低");
                dat.add("从低到高");
                alertWindow(view, dat, 10);
                break;
            case R.id.ll3:
                dat.add("住宅");
                dat.add("商铺");
                dat.add("写字楼");
                dat.add("工业厂房");
                alertWindow(view, dat, 11);
                break;
        }
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
        }
    }
}
