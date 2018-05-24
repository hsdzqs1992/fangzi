package com.zhuye.ershoufang.adapter.me;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.XiaoXiBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MessageAdapter extends BaseQuickAdapter<XiaoXiBean,BaseViewHolder> {


    public MessageAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, XiaoXiBean item) {
            helper.setText(R.id.title,item.getMessage())
                    .setText(R.id.time,item.getCreate_time())
                    .setText(R.id.content,item.getMessage());
    }
}
