package com.zhuye.ershoufang.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.bean.HomeJinBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class HomeJingJiAdapter extends BaseQuickAdapter<HomeJinBean,BaseViewHolder> {

    public HomeJingJiAdapter(int layoutResId) {
        super(layoutResId);
    }



    @Override
    protected void convert(BaseViewHolder helper,HomeJinBean item) {
        //helper.setImageResource(R.id.pic,item.imgRes).setText(R.id.name,item.stringRes);
    }
}
