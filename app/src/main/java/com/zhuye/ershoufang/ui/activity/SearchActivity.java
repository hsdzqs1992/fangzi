package com.zhuye.ershoufang.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.SearchAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.utils.PageUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.zhuye.ershoufang.utils.PageUtils.FIRST;
import static com.zhuye.ershoufang.utils.PageUtils.LOADMORE;
import static com.zhuye.ershoufang.utils.PageUtils.REFRESH;

public class SearchActivity extends BaseActivity {

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
        setText(ttitle,"搜索");

        adapter2 = new SearchAdapter(R.layout.search_item);
        recycle.setAdapter(adapter2);
        recycle.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().getSearchData("",PageUtils.FIRSTPAGE, SearchActivity.this,FIRST);
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        PageUtils.handleData(SearchActivity.this,requestcode,base,adapter2, refresh);
    }

    @Override
    protected void initListener() {
        super.initListener();
        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
               // PageUtils.requestBefore();
                CommonApi.getInstance().getSearchData("",PageUtils.requestPage, SearchActivity.this,LOADMORE);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //PageUtils.requestBefore();
                CommonApi.getInstance().getSearchData("",PageUtils.FIRSTPAGE, SearchActivity.this,REFRESH);
            }
        });
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
