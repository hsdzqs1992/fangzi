package com.zhuye.ershoufang.adapter.me;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MaiFangWEiItemAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {

    public MaiFangWEiItemAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {

    }
}
