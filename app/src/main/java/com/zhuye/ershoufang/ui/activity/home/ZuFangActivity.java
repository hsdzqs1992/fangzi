package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ZuFangAdapter3;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.one.MyMultipleItem;
import com.zhuye.ershoufang.ui.activity.CommonHome5Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class ZuFangActivity extends CommonHome5Activity<Common3Bean> {


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
    @BindView(R.id.quyu)
    LinearLayout quyu;
    @BindView(R.id.jiage)
    LinearLayout jiage;
    @BindView(R.id.jinjiren)
    LinearLayout jinjiren;

    @Override
    protected int getResId() {
        return R.layout.activity_zu_fang;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "租房");
        adapter = new ZuFangAdapter3(datas);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        getData("4");
    }

    @OnClick({R.id.back, R.id.quyu, R.id.jiage, R.id.jinjiren})
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
            case R.id.jinjiren:
                dat.add("个人");
                dat.add("经纪人");
                alertWindow(view, dat, 12);
                break;
        }
    }


    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 12:
                switch (position){
                    case 0:
                        yonghu = "1";
                        break;
                    case 1:
                        yonghu = "2";
                        break;
                }
                selecechoose("4",REFRESHBASE);
                break;
            case 9:
                business_id =  jiadao.getData().get(position).getId();
                selecechoose("4",REFRESHBASE);
                break;
        }
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
        return smartferesh;
    }

    @Override
    protected void onLoadmore() {
        selecechoose("4",LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        selecechoose("4",REFRESHBASE);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(ZuFangActivity.this, ErShouFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getLife_id());
                startActivity(intent);
            }
        });
    }
}

