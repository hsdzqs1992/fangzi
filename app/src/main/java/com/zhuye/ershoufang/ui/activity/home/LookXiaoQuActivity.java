package com.zhuye.ershoufang.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.FindXiqoQuAdapter;
import com.zhuye.ershoufang.bean.XiaoQuBean2;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LookXiaoQuActivity extends CommonHome2Activity<XiaoQuBean2> {

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
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll2)
    LinearLayout ll2;

    @Override
    protected int getResId() {
        return R.layout.activity_look_xiao_qu;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "找小区");
        adapter = new FindXiqoQuAdapter(R.layout.home_xiaoqi_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }


    String business_id;
    String price;

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().find_xiaoqu(getQuId(), business_id, price, page, LookXiaoQuActivity.this, LIST);
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
        CommonApi.getInstance().find_xiaoqu(getQuId(), business_id, price, ++page, LookXiaoQuActivity.this, LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().find_xiaoqu(getQuId(), business_id, price, 1, LookXiaoQuActivity.this, REFRESHBASE);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(LookXiaoQuActivity.this, LookXiaoQuDetailActivity.class);
//                intent.putExtra("id",list.get(position).getId());
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.tv2, R.id.ll2})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.tv2:
            case R.id.ll2:
                dat.clear();
                dat.add("价格从低到高");
                dat.add("价格从高到低");
                alertWindow(view, dat, 11);
                break;
        }
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 11:
                if(position==0){
                    price ="desc";
                }else {
                    price ="asc";
                }
                onRefresh();
                break;
        }
    }
}
