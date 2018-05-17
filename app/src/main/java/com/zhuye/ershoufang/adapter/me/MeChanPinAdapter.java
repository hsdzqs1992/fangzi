package com.zhuye.ershoufang.adapter.me;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.ChanPinBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeChanPinAdapter extends BaseQuickAdapter<ChanPinBean,BaseViewHolder> {


    public MeChanPinAdapter(int layoutResId) {
        super(layoutResId);
    }
    @Override
    protected void convert(BaseViewHolder helper, ChanPinBean item) {
        ImageView view =helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(view);
        helper.setText(R.id.title,item.getTitle()).addOnClickListener(R.id.zhiding)
        .addOnClickListener(R.id.delete).addOnClickListener(R.id.bianji);
    }
}
