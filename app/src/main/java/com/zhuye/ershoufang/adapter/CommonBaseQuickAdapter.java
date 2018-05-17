package com.zhuye.ershoufang.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public abstract class CommonBaseQuickAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K>  {

    public CommonBaseQuickAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    public CommonBaseQuickAdapter(@Nullable List data) {
        super(data);
    }

    public CommonBaseQuickAdapter(int layoutResId) {
        super(layoutResId);
    }

    public void clear(){
        int count = mData.size();
        mData.clear();
        notifyItemMoved(0,count);
    }


}
