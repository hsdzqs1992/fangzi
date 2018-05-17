package com.zhuye.ershoufang.adapter.me;

import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.CommonBaseQuickAdapter;
import com.zhuye.ershoufang.bean.WenDaBean;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class WenDaAdapter extends CommonBaseQuickAdapter<WenDaBean,BaseViewHolder> {

    public WenDaAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, WenDaBean item) {

        helper.setText(R.id.titless,item.getQuestion()).
                setText(R.id.mianshua,item.getIntro()).setText(R.id.time,item.getCreate_time())
                .setText(R.id.pinglun,item.getAnswer()).addOnClickListener(R.id.pinglun);
    }

    //public


}
