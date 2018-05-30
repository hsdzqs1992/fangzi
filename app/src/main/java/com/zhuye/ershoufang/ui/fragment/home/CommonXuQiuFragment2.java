package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.JingMaiAdapter2;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.JingMaiBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.JingMaiDetailActivity2;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public class CommonXuQiuFragment2 extends CommonFragment<JingMaiBean> {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode,o);
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
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }



    public void getData(int po){
        if(list!=null){
            list.clear();
        }
        switch (po){
            case 1:
                cate_id = "1";
                break;
            case 2:
                cate_id = "2";
                break;
            case 3:
                cate_id = "3";
                break;
            case 4:
                cate_id = "4";
                break;
        }
        CommonApi.getInstance().bidder_list(cate_id,getQuId(),page,CommonXuQiuFragment2.this,LIST);
    }


    String cate_id = "1";
    @Override
    protected void initData() {
        super.initData();
        adapte = new JingMaiAdapter2(R.layout.jingmai_item);
        recycle.setAdapter(adapte);
        // TODO: 2018/3/23 0023       有bug
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        getData(1);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
               // start(JingMaiDetailActivity.class,position+"");
                Intent intent = new Intent(getActivity(),JingMaiDetailActivity2.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().bidder_list(cate_id,getQuId(),++page,CommonXuQiuFragment2.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().bidder_list(cate_id,getQuId(),1,CommonXuQiuFragment2.this,REFRESHBASE);
    }



}
