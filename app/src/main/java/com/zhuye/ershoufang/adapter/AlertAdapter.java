package com.zhuye.ershoufang.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class AlertAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public AlertAdapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv,item);
    }
}
