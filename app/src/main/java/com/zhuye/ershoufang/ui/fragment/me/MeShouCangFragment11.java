package com.zhuye.ershoufang.ui.fragment.me;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.XinFangshouAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.XinFangDetailActivity;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MeShouCangFragment11 extends CommonFragment<Common5Bean> {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;


    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }

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
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().newhouse_collect(getToken(),++page,MeShouCangFragment11.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().newhouse_collect(getToken(),1,MeShouCangFragment11.this,REFRESHBASE);
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().newhouse_collect(getToken(),page,MeShouCangFragment11.this,LIST);
    }

    @Override
    protected void initView() {
        //adapte = new XinFangAdapter3()
        adapte = new XinFangshouAdapter(R.layout.home_xinfang_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //进入新房详情页
                Intent intent = new Intent(getActivity(), XinFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });
    }
}
