package com.zhuye.ershoufang.adapter.home;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.one.MyMultipleItem;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ChangFangAdapter2 extends BaseMultiItemQuickAdapter<MyMultipleItem<CommonBean>,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ChangFangAdapter2(List<MyMultipleItem<CommonBean>> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultipleItem<CommonBean> item) {

    }
}
