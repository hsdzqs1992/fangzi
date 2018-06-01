package com.zhuye.ershoufang.ui.fragment.tuijian;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TuiJianViewAdapter2;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.TuiJianViewFragment;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class TuiJianViewFragment2 extends TuiJianViewFragment<Common3Bean> {

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().index("3",getQuId(),page,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,LIST,false);
    }

    @Override
    protected void clickhuxing(View view) {

    }

    @Override
    protected void initView() {
        adapte = new TuiJianViewAdapter2(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().index("3",getQuId(),++page,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().index("3",getQuId(),1,business_id,prce1,prce2,select1,yonghu,"","1",
                TuiJianViewFragment2.this,REFRESHBASE,true);
    }
}
