package com.zhuye.ershoufang.adapter.home;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.XiaoQuBean2;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class FindXiqoQuAdapter extends BaseQuickAdapter<XiaoQuBean2,BaseViewHolder> {


    public FindXiqoQuAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, XiaoQuBean2 item) {
        ImageView imageView = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);

             helper.setText(R.id.title,item.getXiaoqu()).
                     setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name())
                     .setText(R.id.mianji,"三室两厅 "+item.getCount()+" m²")
                 .setText(R.id.price,item.getPrice());
    }
}
