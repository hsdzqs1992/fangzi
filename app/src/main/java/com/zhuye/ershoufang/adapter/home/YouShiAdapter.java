package com.zhuye.ershoufang.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class YouShiAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public YouShiAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv,item);
    }
}
