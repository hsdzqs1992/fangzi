package com.zhuye.ershoufang.adapter.me;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.FaBuListBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MaiFangItemAdapter extends BaseQuickAdapter<FaBuListBean.DataBean,BaseViewHolder> {


    public MaiFangItemAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, FaBuListBean.DataBean item) {

        ImageView imageView = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);

        helper.setText(R.id.title,item.getTitle())
                .setText(R.id.price,item.getNum1())
                .setText(R.id.leixingmianji,item.getSelect1_name()==null ? "": item.getSelect1_name()+item.getNum1())
                .setText(R.id.leixing,"二手房")
        .addOnClickListener(R.id.edit).addOnClickListener(R.id.delete)
        .addOnClickListener(R.id.zhiding);


    }
}
