package com.zhuye.ershoufang.adapter.me;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.FaBuListBean2;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MaiFangItemAdapter extends BaseQuickAdapter<FaBuListBean2,BaseViewHolder> {


    public MaiFangItemAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, FaBuListBean2 item) {

        ImageView imageView = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
        helper.setText(R.id.title,item.getTitle())
                .setText(R.id.price,item.getNum1())
                .setText(R.id.leixingmianji,item.getSelect1_name()==null ? "": item.getSelect1_name()+"  " +item.getNum1()+"m²")
                .setText(R.id.leixing,"")
                .setText(R.id.state,item.getAudit()==0 ? "审核中":"")
        .addOnClickListener(R.id.edit).addOnClickListener(R.id.delete)
        .addOnClickListener(R.id.zhiding);
//        TextView textView = helper.getView(R.id.edit);
//        textView.setClickable(item.getAudit()==0? false:true);
//        textView.setFocusable(item.getAudit()==0?false:true);
    }
}
