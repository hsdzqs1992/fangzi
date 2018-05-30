package com.zhuye.ershoufang.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.SearchAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CiYuBean;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.SearchBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.CommonHome2Activity;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends CommonHome2Activity<SearchBean> {
    private static final int GETDATA = 777;
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
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;

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

    CommonListBean<CiYuBean> bean;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case GETDATA:
//                bean = (CommonListBean<CiYuBean>) o;
//
//                List<String> dd = new ArrayList<>();
//                for (CiYuBean d: bean){
//
//
//                mFlowLayout.setAdapter(new TagAdapter<String>(mVals)
//                {
//                    @Override
//                    public View getView(FlowLayout parent, int position, String s)
//                    {
//                        TextView tv = (TextView) mInflater.inflate(R.layout.tv,
//                                mFlowLayout, false);
//                        tv.setText(s);
//                        return tv;
//                    }
//                });

                idFlowlayout.setAdapter(new TagAdapter<CiYuBean>(bean.getData())
                {
                    @Override
                    public View getView(FlowLayout parent, int position, CiYuBean ciYuBean) {
                        TextView tv = (TextView) getLayoutInflater().inflate(R.layout.tv,
                                idFlowlayout, false);
                        tv.setText(ciYuBean.getMessage());
                        return tv;
                    }

//                    @Override
//                    public View getView(FlowLayout parent, int position, CityBean s)
//                    {
//                        TextView tv = (TextView) getLayoutInflater().inflate(R.layout.tv,
//                                idFlowlayout, false);
//                        tv.setText(s);
//                        return tv;
//                    }
                });

                break;
        }
    }




    @Override
    protected void initListener() {
        super.initListener();

        idFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
                Toast.makeText(SearchActivity.this, bean.getData().get(position).getMessage(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        // CommonApi.getInstance().getSearchData("", PageUtils.FIRSTPAGE, SearchActivity.this, LIST);


        CommonApi.getInstance().ciyu(SearchActivity.this, GETDATA);

//        CommonApi.getInstance().ciyu(SearchActivity.this, GETDATA)
//                .map(new Function() {
//                    @Override
//                    public Object apply(Object o) throws Exception {
//                        return o;
//                    }
//                });
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
                dat.clear();
                dat.add("新房");
                dat.add("二手房");
                dat.add("租房");
                alertWindow(view, dat, 11);
                break;
            case R.id.input:
                break;
            case R.id.quxiao:
                if (checkEmpty(input, "请输入搜索内容")) {
                    sear = getString(input);
                    getData(LIST, sear);
                }
                break;
        }
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        //清空数据
        list.clear();
        switch (rescode) {
            case 11:
                switch (position) {
                    case 0:
                        type = XINFANG;
                        xinfang.setText("新房");
                        break;
                    case 1:
                        type = ERSHOUFANG;
                        xinfang.setText("二手房");
                        break;
                    case 2:
                        type = ZUFANG;
                        xinfang.setText("租房");
                        break;
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
