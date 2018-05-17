package com.zhuye.ershoufang.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.SelectBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class SelectAdapter extends BaseQuickAdapter<SelectBean,BaseViewHolder> {

    public SelectAdapter(int layoutResId) {
        super(layoutResId);
    }



    @Override
    protected void convert(BaseViewHolder helper,SelectBean item) {
        //helper.setImageResource(R.id.pic,item.imgRes).setText(R.id.name,item.stringRes);
        helper.setText(R.id.setv,item.name);
    }
}
