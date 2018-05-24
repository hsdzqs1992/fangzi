package com.zhuye.ershoufang.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.SearchAdapter;
import com.zhuye.ershoufang.bean.SearchBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.CommonHome2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends CommonHome2Activity<SearchBean> {
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.quxiao)
    TextView quxiao;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

//    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    @BindView(R.id.recycle)
//    RecyclerView recycle;
//    @BindView(R.id.refresh)
//    SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.activity_search;
    }


    //
//    @Override
//    protected void initView() {
//        super.initView();
//        hide(subtitle);
//        setText(ttitle,"搜索");
//
//        adapter2 = new SearchAdapter(R.layout.search_item);
//        recycle.setAdapter(adapter2);
//        recycle.setLayoutManager(new LinearLayoutManager(this));
//
//
//    }
//
//


    private int type = XINFANG;
    private final static int XINFANG = 150;
    private final static int ERSHOUFANG = 151;
    private final static int ZUFANG = 152;

    @Override
    protected void initView() {
        super.initView();
        adapter = new SearchAdapter(R.layout.search_item);

    }

    @Override
    protected void initData() {
        super.initData();
        // CommonApi.getInstance().getSearchData("", PageUtils.FIRSTPAGE, SearchActivity.this, LIST);
        //  getData(LIST);
    }

    private void getData(int code, String key) {
        switch (type) {
            case XINFANG:
                switch (code) {
                    case LIST:
                        CommonApi.getInstance().indexnewhouse2(getQuId(),
                                "", "",
                                "", 1, 1, key
                                , SearchActivity.this, LIST);
                        break;
                    case REFRESHBASE:
                        CommonApi.getInstance().indexnewhouse2(getQuId(),
                                "", "",
                                "", 1, 1, key
                                , SearchActivity.this, REFRESHBASE);
                        break;
                    case LOADMOREBASE:
                        CommonApi.getInstance().indexnewhouse2(getQuId(),
                                "", "",
                                "", 1, ++page,
                                key,
                                SearchActivity.this
                                , LOADMOREBASE);
                        break;
                }
                break;
            case ERSHOUFANG:
                switch (code) {
                    case LIST:
                        CommonApi.getInstance().index("3", getQuId(), 1,
                                "", "",
                                "", "",
                                "", key,
                                SearchActivity.this, LIST);
                        break;
                    case REFRESHBASE:
                        CommonApi.getInstance().index("3", getQuId(), ++page
                                , "", "",
                                "", "",
                                "", key,
                                SearchActivity.this, REFRESHBASE);
                        break;
                    case LOADMOREBASE:
                        CommonApi.getInstance().index("3", getQuId(),
                                1, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this, LOADMOREBASE);
                        break;
                }
                break;

            case ZUFANG:
                switch (code) {
                    case LIST:
                        CommonApi.getInstance().index("4", getQuId(),
                                1, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this, LIST);
                        break;
                    case REFRESHBASE:
                        CommonApi.getInstance().index("4", getQuId(),
                                1, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this, REFRESHBASE);
                        break;
                    case LOADMOREBASE:
                        CommonApi.getInstance().index("4", getQuId(),
                                1, "",
                                "", "", "",
                                "", key,
                                SearchActivity.this, LOADMOREBASE);
                        break;
                }
                break;
        }
        //CommonApi.getInstance()
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    String sear;

    @Override
    protected void onLoadmore() {
        getData(LOADMOREBASE, sear);
    }

    @Override
    protected void onRefresh() {
        getData(REFRESHBASE, sear);
    }


    @OnClick({R.id.xinfang, R.id.input, R.id.quxiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinfang:
                dat.add("新房");
                dat.add("二手房");
                dat.add("租房");
                alertWindow(view, dat, 11);
                break;
            case R.id.input:
                break;
            case R.id.quxiao:
                if(checkEmpty(input,"请输入搜索内容")){
                    sear = getString(input);
                    getData(LIST,sear);
                }
                break;
        }
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        //清空数据
        list.clear();
        switch (rescode){
            case 11:
                switch (position){
                    case 0:
                        type = XINFANG;
                        break;
                    case 1:
                        type=ERSHOUFANG;
                        break;
                    case 2:
                        type = ZUFANG;
                        break;
                }
                break;
        }
    }

    //
//    @Override
//    public void success(int requestcode, Base base) {
//        super.success(requestcode, base);
//        PageUtils.handleData(SearchActivity.this,requestcode,base,adapter2, refresh);
//    }
//
//    @Override
//    protected void initListener() {
//        super.initListener();
//        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
//            @Override
//            public void onLoadmore(RefreshLayout refreshlayout) {
//               // PageUtils.requestBefore();
//                CommonApi.getInstance().getSearchData("",PageUtils.requestPage, SearchActivity.this,LOADMORE);
//            }
//
//            @Override
//            public void onRefresh(RefreshLayout refreshlayout) {
//                //PageUtils.requestBefore();
//                CommonApi.getInstance().getSearchData("",PageUtils.FIRSTPAGE, SearchActivity.this,REFRESH);
//            }
//        });
//    }
//
//    @OnClick(R.id.back)
//    public void onViewClicked() {
//        finish();
//    }
}
