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
import com.zhuye.ershoufang.adapter.home.HomeJingJiAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.SelectBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
//HomeWindowActivity
public class JingJiRenActivity extends Common2Activity {

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

    @Override
    protected int getResId() {
        return R.layout.common4;
    }
    HomeJingJiAdapter jiAdapter ;
    @Override
    protected void initView() {
        super.initView();
        // hide(subtitle);
        setText(ttitle, "经纪人");
       // setText(subtitle, "区域选择");
        hide(subtitle);
        jiAdapter = new HomeJingJiAdapter(R.layout.home_jingji_item);
        recycle.setAdapter(jiAdapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

    }



    @OnClick({R.id.jiage,R.id.quyu,R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        //List<SelectBean> data = new ArrayList<>();
        List<String> data = new ArrayList<>();
        switch (view.getId()) {
            case R.id.jiage:
//                data.add(new SelectBean("desc","价格从高到底"));
//                data.add(new SelectBean("desc","价格从高到底"));
                data.add("价格从高到底");
                data.add("价格从高到底");
                alertWindow(view,data,9);
                break;
            case R.id.quyu:
                alertWindow(view,data,10);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                //start(QuYuSelectActivity.class);
                break;
        }
    }


    String paixu = "desc";

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().agent_list(page,getQuId(),paixu,JingJiRenActivity.this,LIST);
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
//        switch (requestcode){
//            case LIST:
//                CommonListBean<HomeJinBean> da = (CommonListBean<HomeJinBean>) base;
//                if(da.getData()!=null)
//                jiAdapter.addData(da.getData());
//
//                break;
//        }
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return jiAdapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().agent_list(++page,getQuId(),paixu,JingJiRenActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().agent_list(1,getQuId(),paixu,JingJiRenActivity.this,REFRESHBASE);
    }
}
