package com.zhuye.ershoufang.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class CommonAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {


    public CommonAdapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, T item) {


    }
}
