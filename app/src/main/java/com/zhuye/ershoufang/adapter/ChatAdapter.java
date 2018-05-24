package com.zhuye.ershoufang.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ChatAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {


    public ChatAdapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, T item) {


    }
}
