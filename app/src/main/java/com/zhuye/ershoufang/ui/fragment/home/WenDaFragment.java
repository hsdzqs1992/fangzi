package com.zhuye.ershoufang.ui.fragment.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.WenDaAdapter;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.WenDaBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class WenDaFragment extends BaseFragment {
    private static final int LIST = 200;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;
    WenDaAdapter adapter;
    @Override
    protected void initView() {
        adapter = new WenDaAdapter(R.layout.wenda_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.body;
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().questionindex(type, page, WenDaFragment.this, LIST);
    }

    public int type = 1;
    public int page = 1;


    CommonListBean<WenDaBean> data;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case LIST:
                data = (CommonListBean<WenDaBean>) o;
                adapter.addData(data.data);
                break;
        }
    }
}
