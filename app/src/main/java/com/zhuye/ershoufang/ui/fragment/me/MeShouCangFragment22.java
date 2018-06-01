package com.zhuye.ershoufang.ui.fragment.me;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.ErshouAdapter;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MeShouCangFragment22 extends CommonFragment<Common3Bean> {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

//    @Override
//    protected void doList() {
//        datas.clear();
//        for (int i = 0;i<list.size();i++){
//            if(list.size()>2){
//                if(i==1){
//                    datas.add(new MyMultipleItem(MyMultipleItem.SECOND_TYPE,list.get(i)));
//                }else {
//                    datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,list.get(i)));
//                }
//            }else {
//                datas.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE,list.get(i)));
//            }
//        }
//    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().life_cang(getToken(),page,1,MeShouCangFragment22.this,LIST);
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().life_cang(getToken(),++page,1,MeShouCangFragment22.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().life_cang(getToken(),1,1,MeShouCangFragment22.this,REFRESHBASE);
    }

    @Override
    protected void initView() {
        adapte =  new ErshouAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(layoutManager);
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }
}