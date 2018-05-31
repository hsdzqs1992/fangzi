package com.zhuye.ershoufang.ui.fragment.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.WenDaAdapter;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.WenDaBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class WenDaFragment extends CommonFragment<WenDaBean> {

    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

    @Override
    protected void initView() {
        adapte = new WenDaAdapter(R.layout.wenda_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().questionindex(type, page, WenDaFragment.this, LIST,true);
    }

    public int type = 1;
    public int page = 1;


    CommonListBean<WenDaBean> data;

//    @Override
//    public void success(int requestcode, Base o) {
//        super.success(requestcode, o);
//        switch (requestcode) {
//            case LIST:
//                data = (CommonListBean<WenDaBean>) o;
//                adapter.addData(data.data);
//                break;
//        }
//    }

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
        CommonApi.getInstance().questionindex(type, ++page, WenDaFragment.this, LOADMOREBASE,true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().questionindex(type, 1, WenDaFragment.this, REFRESHBASE,true);
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapte.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(),HomeWenDadetailActivity.class);
                intent.putExtra("id",list.get(position).getQuestion_id());
                startActivity(intent);
            }
        });
    }

    public void getData(int type ){
        list.clear();
        this.type = type;
        CommonApi.getInstance().questionindex(type, 1, WenDaFragment.this, LIST,false);
    }
}
