package com.zhuye.ershoufang.ui.fragment.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public class CommonXieZiFragment extends CommonFragment<Common3Bean> {

    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.footer)
    ClassicsFooter footer;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.ershou)
    TextView ershou;
    @BindView(R.id.zulin)
    TextView zulin;
    @BindView(R.id.di1)
    TextView di1;
    @BindView(R.id.di2)
    TextView di2;
    @BindView(R.id.di3)
    TextView di3;
    @BindView(R.id.di4)
    TextView di4;
    @BindView(R.id.di5)
    RelativeLayout di5;
    @BindView(R.id.jia1)
    TextView jia1;
    @BindView(R.id.jia2)
    TextView jia2;
    @BindView(R.id.jia3)
    TextView jia3;
    @BindView(R.id.jia4)
    TextView jia4;
    Unbinder unbinder1;

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
        CommonApi.getInstance().index(cate_id, getQuId(), ++page,
                "", price1, price2, select1, yonghu, key,
                CommonXieZiFragment.this, LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().index(cate_id, getQuId(), 1,
                "", price1, price2, select1, yonghu, key,
                CommonXieZiFragment.this, REFRESHBASE);
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
        CommonApi.getInstance().index(cate_id, getQuId(), page,
                "", price1, price2, select1, yonghu, key,
                CommonXieZiFragment.this, LIST);
    }

    private String cate_id = "12";


    public void choose(TextView ... args) {

        Drawable whitebg = getResources().getDrawable(R.drawable.shape_lan);
        int pramy = getResources().getColor(R.color.qianse);

        int white = getResources().getColor(R.color.gray);
       // Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);

        TextView tv0 = args[0];
        tv0.setTextColor(pramy);
        tv0.setBackground(whitebg);


        for (int i = 1;i<args.length;i++){
            args[i].setTextColor(white);
            args[i].setBackground(null);
        }


        //textView.setTextColor(pramy);
        //textView.setBackground(whitebg);

//        textView1.setTextColor(white);
//        textView1.setBackground(pramybg);
//        textView2.setTextColor(white);
//        textView2.setBackground(pramybg);
    }

//    public void choose(TextView textView, TextView textView1, TextView textView2) {
//        int white = getResources().getColor(R.color.white);
//        Drawable whitebg = getResources().getDrawable(R.drawable.shape_tuijian);
//        int pramy = getResources().getColor(R.color.colorPrimary);
//        Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);
//        textView.setTextColor(pramy);
//        textView.setBackground(whitebg);
//
//        textView1.setTextColor(white);
//        textView1.setBackground(pramybg);
//        textView2.setTextColor(white);
//        textView2.setBackground(pramybg);
//    }

    @OnClick({R.id.xinfang, R.id.ershou, R.id.zulin, R.id.di1, R.id.di2, R.id.di3, R.id.di4, R.id.di5, R.id.jia1, R.id.jia2, R.id.jia3, R.id.jia4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinfang:
                choose(xinfang, ershou, zulin);
                break;
            case R.id.ershou:
                choose(ershou, xinfang, zulin);
                break;
            case R.id.zulin:
                choose(zulin, xinfang, ershou);
                break;
            case R.id.di1:
                choose(di1, di2, di3,di4);
                break;
            case R.id.di2:
                choose(di2, di1, di3,di4);
                break;
            case R.id.di3:
                choose(di3, di2, di1,di4);
                break;
            case R.id.di4:
                choose(di4, di2, di3,di1);
                break;
            case R.id.di5:
                break;
            case R.id.jia1:
                choose(jia1, jia2, jia3,jia4);
                break;
            case R.id.jia2:
                choose(jia2, jia1, jia3,jia4);
                break;
            case R.id.jia4:
                choose(jia4, jia2, jia3,jia1);
                break;
            case R.id.jia3:
                choose(jia3, jia2, jia4,jia1);
                break;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
