package com.zhuye.ershoufang.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class Common2Adapter extends BaseQuickAdapter<CommonBean,BaseViewHolder> {


    public Common2Adapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, CommonBean item) {
       ImageView imageView =  helper.getView(R.id.photo);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
        helper.setText(R.id.tuijian,"推荐理由"+item.getRecommand()).setText(R.id.price,item.getPrice()+"元/m²")
                .setText(R.id.dizhi,item.getArea_name()+"-"+item.getBusiness_name());

        String state = item.getIs_onsale();
        TextView  textView =helper.getView(R.id.state);
        if(state.equals("0")){
            textView.setText("期末在售");
        }else if(state.equals("1")){
            textView.setText("期末在售");
        }else if(state.equals("2")){
            textView.setText("期末在售");
        }
    }
}
