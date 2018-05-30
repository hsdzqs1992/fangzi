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
import com.zhuye.ershoufang.adapter.home.ErFangAdapter2;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.one.MyMultipleItem;
import com.zhuye.ershoufang.ui.activity.CommonHome5Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class ErShouFangActivity extends CommonHome5Activity<Common3Bean> {


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
    @BindView(R.id.quyu)
    LinearLayout quyu;
    @BindView(R.id.jiage)
    LinearLayout jiage;
    @BindView(R.id.huxing)
    LinearLayout huxing;
    @BindView(R.id.video)
    LinearLayout video;

    @Override
    protected int getResId() {
        return R.layout.activity_er_shou_fang;
    }


    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("二手房");
        subtitle.setVisibility(View.GONE);
        adapter = new ErFangAdapter2(datas);
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
                Intent intent = new Intent(ErShouFangActivity.this, ErShouFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getLife_id());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onLoadmore() {
        selecechoose("3",LOADMOREBASE);
//        CommonApi.getInstance().index(
//                "3",qu_id,++page,
//                business_id,prices1,prices2,select1,yonghu,"",
//                ErShouFangActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
//        CommonApi.getInstance().index("3",qu_id,1,business_id,prices1,prices2,select1,yonghu,"",
//                ErShouFangActivity.this,REFRESHBASE);

        selecechoose("3",REFRESHBASE);
    }


    @Override
    protected void doList() {
        datas.clear();
        for (int i = 0;i<list.size();i++){
            if(list.size()>2){
                if(i==1){
                    datas.add(new MyMultipleItem(MyMultipleItem.SECOND_TYPE,list.get(i)));
                }else {
                    datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,list.get(i)));
                }
            }else {
                datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,list.get(i)));
            }
        }
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
    protected void initData() {
        super.initData();
       getData("3");
    }

    @OnClick({R.id.back, R.id.quyu, R.id.jiage, R.id.huxing, R.id.video})
    public void onViewClicked(View view) {
        dat.clear();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.quyu:
                clickJieDao(view);
                break;
            case R.id.jiage:
                alertjiageWindow(view,100);
                break;
            case R.id.huxing:
                clickLeiXing(view);
                break;
            case R.id.video:
                dat.add("有视频");
                dat.add("无视频");
                alertWindow(view, dat, 12);
                break;
        }
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 11:
                selecechoose("3",REFRESHBASE);
                break;
            case 12:

                break;

        }
    }
//
//    @Override
//    public void getClickPrice(String price1, String price2) {
//        super.getClickPrice(price1, price2);
//        prices2 = price2;
//        prices1 = price1;
//        selecechoose("3",REFRESHBASE);
//    }




}
