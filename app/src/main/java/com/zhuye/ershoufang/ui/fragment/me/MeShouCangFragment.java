package com.zhuye.ershoufang.ui.fragment.me;

import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.one.MyMultipleItem;
import com.zhuye.ershoufang.one.XinFangAdapter3;
import com.zhuye.ershoufang.ui.fragment.common.MutiCommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MeShouCangFragment extends MutiCommonFragment<Common5Bean> {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

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
        return adapte;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().newhouse_collect(getToken(),++page,MeShouCangFragment.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().newhouse_collect(getToken(),1,MeShouCangFragment.this,REFRESHBASE);
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().newhouse_collect(getToken(),page,MeShouCangFragment.this,LIST);
    }

    @Override
    protected void initView() {
        //adapte = new XinFangAdapter3()
        adapte = new XinFangAdapter3(datas);
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }

}
