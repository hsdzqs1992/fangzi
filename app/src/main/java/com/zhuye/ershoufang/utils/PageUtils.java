package com.zhuye.ershoufang.utils;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.adapter.CommonBaseQuickAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;

import java.util.List;

/**
 * 分页的工具类
 */

public class PageUtils<T> {

    public static final int FIRST = 300;
    public static final int REFRESH = 301;
    public static final int LOADMORE = 302;
    public static final int DELETE = 303;

    public static int currentPage = 1;
    public static int requestPage = 1;
    public static final int FIRSTPAGE = 1;


    // TODO: 2018/4/2 0002
    public static CommonListBean totalData = new CommonListBean();
    public static CommonListBean tempData ;

    public T daa;
    public List<T> data;
    //www.souho.net

    /**
     *   简单的分页处理类  常用处理
     * @param requestcode
     * @param base
     * @param adapter
     * @param refresh
     */
    public static void handleData(BaseActivity baseActivity , int requestcode, Base base, CommonBaseQuickAdapter adapter, SmartRefreshLayout refresh) {
        tempData = (CommonListBean) base;
        switch (requestcode){
            case FIRST:
                if (tempData.getData()!=null && tempData.getData().size()>0){
                    adapter.addData(tempData.getData());
                    totalData.setData(tempData.getData());
                }

                break;
            case REFRESH:
                adapter.clear();
                if (tempData.getData()!=null && tempData.getData().size()>0){
                    adapter.addData(tempData.getData());
                    totalData.getData().clear();
                    totalData.setData(tempData.getData());
                }
                refresh.finishRefresh();
                break;
            case LOADMORE:
                 ++requestPage;
                // 最后一页  没有数据的处理
                if(tempData.getData()==null || tempData.getData().size()==0){
                    --requestPage;
                }
                refresh.finishLoadmore();
                if (tempData.getData()!=null && tempData.getData().size()>0){
                    adapter.addData(totalData.getData().size(),tempData.getData());
                    totalData.getData().addAll(tempData.getData());
                }
                break;
                //长按删除处理
            case DELETE:
                ToastUtils.toast(baseActivity,base.getMessage());
                break;

        }
    }

    /**
     *
     */
    public static void requestBefore() {

    }
}
