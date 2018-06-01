package com.zhuye.ershoufang.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class TuiJianViewAdapter2 extends BaseQuickAdapter<Common3Bean,BaseViewHolder> {


    public TuiJianViewAdapter2(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Common3Bean item) {
        ImageView imageView = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
        helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getNum1()+" m²")
        .setText(R.id.price,item.getNum2());
               // .setText(R.id.dizhi,item.get)
    }
}
