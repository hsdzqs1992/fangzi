package com.zhuye.ershoufang.adapter.me.qite;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.QiTeBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class QiTe1Adapter extends BaseQuickAdapter <QiTeBean,BaseViewHolder> {


    public QiTe1Adapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, QiTeBean item) {
//        ImageView imageView = helper.getView(R.id.image);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
        helper.setText(R.id.title,item.getXiaoqu())
                .setText(R.id.leixingmianji,item.getSelect1())
                .setText(R.id.leixing,item.getAgent().equals("")? "":"经纪人:"+item.getAgent())
                .setText(R.id.zhiding,item.getNum2()+"万元/月")
                .setText(R.id.delete,item.getAgent_mobile());
    }
}
