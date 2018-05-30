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
import com.zhuye.ershoufang.adapter.home.ChangFangAdapter2;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.one.MyMultipleItem;
import com.zhuye.ershoufang.ui.activity.CommonHome5Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class GongYechangFangActivity extends CommonHome5Activity<Common3Bean> {

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
        CommonApi.getInstance().plant_list(cate_id,getQuId(),++page,key,GongYechangFangActivity.this
                ,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().plant_list(cate_id,getQuId(),1,key,GongYechangFangActivity.this
                ,REFRESHBASE);
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
                dat.clear();
              //  alertjiageWindow(view,100);
                dat.add("出售");
                dat.add("出租");
                alertWindow(view, dat, 11);
                break;
        }
    }

    String cate_id = "8";
    String key ;
    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().plant_list(cate_id,getQuId(),page,key,GongYechangFangActivity.this
        ,LIST);
    }

    @Override
    public void getClickPrice(String price1, String price2) {
        super.getClickPrice(price1, price2);
    }

    @Override
    protected void onItemClick(View view, int position, int rescode) {
        super.onItemClick(view, position, rescode);
        switch (rescode){
            case 11:
                switch (position){
                    case 0:
                        cate_id = "8";
                        break;
                    case 1 :
                        cate_id = "10";
                        break;
                }
                CommonApi.getInstance().plant_list(cate_id,getQuId(),1,key,GongYechangFangActivity.this
                        ,REFRESHBASE);
                break;

        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(GongYechangFangActivity.this, GongYeDetailActivity.class);
                intent.putExtra("id",list.get(position).getLife_id());
                startActivity(intent);
            }
        });
    }
}
