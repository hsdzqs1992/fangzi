package com.zhuye.ershoufang.ui.activity.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ChangFangAdapter2;
import com.zhuye.ershoufang.bean.CommonBean;

import butterknife.BindView;
import butterknife.OnClick;

public class GongYechangFangActivity extends CommonHomeActivity<CommonBean> {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.smartferesh)
    SmartRefreshLayout smartferesh;

    @Override
    protected int getResId() {
        return R.layout.activity_gong_yechang_fang;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"工业厂房");
        adapter = new ChangFangAdapter2(datas);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void doList() {

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
    protected void onLoadmore() {

    }

    @Override
    protected void onRefresh() {

    }


    @OnClick({R.id.back, R.id.ll1, R.id.ll2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ll1:
                clickJieDao(view);
                break;
            case R.id.ll2:
                alertjiageWindow(view,100);
                break;
        }
    }

    @Override
    public void getClickPrice(String price1, String price2) {
        super.getClickPrice(price1, price2);
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 9:

                break;
        }
    }
}
