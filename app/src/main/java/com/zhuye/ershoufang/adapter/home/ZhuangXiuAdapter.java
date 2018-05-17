package com.zhuye.ershoufang.adapter.home;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ZhuangXiuAdapter extends BaseQuickAdapter<ZhuangxiuJiaJuBean,BaseViewHolder> {


    public ZhuangXiuAdapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, ZhuangxiuJiaJuBean item) {
            ImageView imageView = helper.getView(R.id.image);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getShop_face()).into(imageView);
        helper.setText(R.id.title,item.getShop_detail()).setText(R.id.name,item.getShop());
    }
}
