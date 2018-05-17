package com.zhuye.ershoufang.ui.activity.common;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.AlertAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.utils.Contants;

import java.util.List;

/**
 * 分页的公共类
 */
public abstract class Common2Activity<T> extends BaseActivity<T> {

    public int page = 1;
    protected static final int LIST = 900;


    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case LIST:
                listData = (CommonListBean)o;
                list = listData.data;
                if(list!=null && list.size()>0){
                    getAdapter().addData(list);
                }
                break;

            case REFRESHBASE:
                listData = (CommonListBean)o;
                // TODO: 2018/5/9 0009 反复试youbug
                if(list!=null && list.size()>0){
                    list.clear();
                    list.addAll(listData.data);
                    getAdapter().replaceData(list);
                }
                getSmartRefreshLayout().finishRefresh();
                break;
            case LOADMOREBASE:
                listData = (CommonListBean)o;
                if(listData.data!=null && listData.data.size()>0){
                    list.addAll(listData.data);
                    if(list!=null && list.size()>0){
                        getAdapter().replaceData(list);
                    }
                }
                getSmartRefreshLayout().finishLoadmore();
                break;

            case Contants.DELETE:
                //todo 删除的处理
                toast(o.getMessage());
                break;

        }
    }

    public abstract BaseQuickAdapter getAdapter();
    public abstract SmartRefreshLayout getSmartRefreshLayout();


    @Override
    protected void initListener() {
        super.initListener();
        getSmartRefreshLayout().setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                Common2Activity.this.onLoadmore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                Common2Activity.this.onRefresh();
            }
        });
    }

    protected abstract void onLoadmore();

    protected abstract void onRefresh();

    protected PopupWindow popupWindow;
    protected RecyclerView recyclerView;
    AlertAdapter alertAdapter;


    protected void alertWindow(View view,List<String> da,int rescode) {
        View vie = View.inflate(this, R.layout.rv, null);
        popupWindow = new PopupWindow(this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        alertAdapter = new AlertAdapter(R.layout.alert_item);
        recyclerView = vie.findViewById(R.id.rv);
        recyclerView.setAdapter(alertAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        alertAdapter.addData(da);
        alertAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (popupWindow!=null&popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                Common2Activity.this.onItemClick(view,position,rescode);
            }
        });
        // 背景的处理
       setBackgroundAlpha(0.5f);//设置屏幕透明度
//        vie.findViewById(R.id.shouru).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                start(AddErShouActivity.class);
//                type = 0;
//
//            }
//        });
//        vie.findViewById(R.id.tixian).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                start(AddXieZiActivity.class);
//                type = 0;
//
//            }
//        });
//
//        vie.findViewById(R.id.shangpu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                type = 0;
//                start(AddShangPuActivity.class);
//            }
//        });
//
//        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                start(AddGongChangActivity.class);
//            }
//        });

        popupWindow.showAsDropDown(view,0,15 );
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        //popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    protected void  onItemClick(View view, int position, int rescode){
    }

    public void addData(List<String> da){
        alertAdapter.replaceData(da);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(getSmartRefreshLayout()!=null)
        getSmartRefreshLayout().autoRefresh();
    }
}
