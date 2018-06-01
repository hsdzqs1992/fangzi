package com.zhuye.ershoufang.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MyPaiMaiItemAdapter1;
import com.zhuye.ershoufang.bean.PaiMaiBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.me.MePaiMai1Fragment;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MePaiMai1Fragment1 extends MePaiMai1Fragment<PaiMaiBean> {


    @Override
    protected void initView() {
        //me_maifang_item
        adapte = new MyPaiMaiItemAdapter1(R.layout.me_paimai_item1);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(this.getActivity()));
    }

    @Override
    protected int getType() {
        return 1;
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().my_wtbidder(getToken(),page,MePaiMai1Fragment1.this,LIST);
    }
    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().my_wtbidder(getToken(),++page,MePaiMai1Fragment1.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().my_wtbidder(getToken(),1,MePaiMai1Fragment1.this,REFRESHBASE);
    }
}
