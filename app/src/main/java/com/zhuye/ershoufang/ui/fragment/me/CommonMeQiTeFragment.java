package com.zhuye.ershoufang.ui.fragment.me;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public abstract class CommonMeQiTeFragment<QiTeBean> extends BaseFragment {
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
                    adapte.addData(list);
                }
                break;


            case REFRESHBASE:
                listData = (CommonListBean)o;
                // TODO: 2018/5/9 0009 反复试youbug

                list.clear();
                list.addAll(listData.data);
                if(list!=null && list.size()>0){
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
                CommonMeQiTeFragment.this.onLoadmore();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                CommonMeQiTeFragment.this.onRefresh();
            }
        });
    }

    protected abstract void onLoadmore();

    protected abstract void onRefresh(); 
}
