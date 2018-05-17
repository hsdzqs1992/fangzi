package com.zhuye.ershoufang.adapter.me;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MianFeiKanAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {


    public MianFeiKanAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {

        helper.addOnClickListener(R.id.zhiding).addOnClickListener(R.id.edit);
    }
}
