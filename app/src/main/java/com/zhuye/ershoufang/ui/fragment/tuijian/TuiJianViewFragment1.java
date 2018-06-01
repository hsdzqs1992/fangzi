package com.zhuye.ershoufang.ui.fragment.tuijian;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TuiJianViewAdapter;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.TuiJianViewFragment;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class TuiJianViewFragment1 extends TuiJianViewFragment<Common5Bean> {

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,1,page,"","1",TuiJianViewFragment1.this,LIST);
    }

    @Override
    protected void clickhuxing(View view) {
        dat.clear();
        dat.add("住宅");
        dat.add("商铺");
        dat.add("写字楼");
        dat.add("工业厂房");
        alertWindow(view, dat, 11);
    }


    @Override
        protected void initView() {
            adapte = new TuiJianViewAdapter(R.layout.home_xinfang_item);
            recycle.setAdapter(adapte);
            recycle.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,1,++page,"","1",TuiJianViewFragment1.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().indexnewhouse2(getQuId(),business_id,prce1,prce2,1,1,"","1",TuiJianViewFragment1.this,REFRESHBASE);
    }
}
