package com.zhuye.ershoufang.adapter.me;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.AnswerBean2;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class WenDaDetailAdapter extends BaseQuickAdapter<AnswerBean2,BaseViewHolder> {


    public WenDaDetailAdapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, AnswerBean2 item) {
        helper.setText(R.id.name,item.getNickname())
                .setText(R.id.time,item.getCreate_time())
                .setText(R.id.content,item.getContent());
        ImageView imageView = helper.getView(R.id.tou);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getFace()).into(imageView);
    }
}
