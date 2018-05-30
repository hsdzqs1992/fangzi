package com.zhuye.ershoufang.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.ShangPuXieAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.fragment.CommonFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public class CommonXieZiFragment extends CommonFragment<Common3Bean> {

    @BindView(R.id.xinfang)
    RelativeLayout xinfang;
    @BindView(R.id.ershou)
    RelativeLayout ershou;
    @BindView(R.id.zulin)
    RelativeLayout zulin;
    @BindView(R.id.di1)
    RelativeLayout di1;
    @BindView(R.id.di2)
    RelativeLayout di2;
    @BindView(R.id.di3)
    RelativeLayout di3;
    @BindView(R.id.di4)
    RelativeLayout di4;
    @BindView(R.id.di5)
    RelativeLayout di5;
    @BindView(R.id.jia1)
    RelativeLayout jia1;
    @BindView(R.id.jia2)
    RelativeLayout jia2;
    @BindView(R.id.jia3)
    RelativeLayout jia3;
    @BindView(R.id.jia4)
    RelativeLayout jia4;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.footer)
    ClassicsFooter footer;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

    @Override
    public void success(int requestcode, Base o) {

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
        CommonApi.getInstance().index(cate_id,getQuId(),++page,
                "",price1,price2,select1,yonghu,key,
                CommonXieZiFragment.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().index(cate_id,getQuId(),1,
                "",price1,price2,select1,yonghu,key,
                CommonXieZiFragment.this,REFRESHBASE);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getResId() {
        return R.layout.fragment_xiezi;
    }

    String business_id;
    String price1;
    String price2;
    String select1;
    String yonghu;
    String key;
    @Override
    protected void initData() {
        super.initData();
        adapte = new ShangPuXieAdapter(R.layout.me_paimai_item);
        CommonApi.getInstance().index(cate_id,getQuId(),page,
                "",price1,price2,select1,yonghu,key,
                CommonXieZiFragment.this,LIST);
    }

    private String cate_id = "12";


    @OnClick({R.id.xinfang, R.id.ershou, R.id.zulin, R.id.di1, R.id.di2, R.id.di3, R.id.di4, R.id.di5, R.id.jia1, R.id.jia2, R.id.jia3, R.id.jia4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinfang:
                break;
            case R.id.ershou:
                break;
            case R.id.zulin:
                break;
            case R.id.di1:
                break;
            case R.id.di2:
                break;
            case R.id.di3:
                break;
            case R.id.di4:
                break;
            case R.id.di5:
                break;
            case R.id.jia1:
                break;
            case R.id.jia2:
                break;
            case R.id.jia4:
                break;
            case R.id.jia3:

                break;

        }
    }
}
