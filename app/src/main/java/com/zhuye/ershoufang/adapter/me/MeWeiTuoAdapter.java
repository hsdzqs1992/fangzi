package com.zhuye.ershoufang.adapter.me;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.QiTeBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeWeiTuoAdapter extends BaseQuickAdapter<QiTeBean,BaseViewHolder> {


    public MeWeiTuoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, QiTeBean item) {
        ImageView view = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(view);

        helper.setText(R.id.title,item.getArea_name()+item.getBusiness_name()+item.getAddr()+item.getXiaoqu())
                .setText(R.id.leixingmianji,item.getNum2()+"万元")
                .setText(R.id.leixing,item.getAgent().equals("")? "":"经纪人:"+item.getAgent())
                .setText(R.id.zhiding,item.getSelect1()+"  "+ item.getNum1()+ " m²")
                .setText(R.id.delete,item.getAgent_mobile());
    }
}
