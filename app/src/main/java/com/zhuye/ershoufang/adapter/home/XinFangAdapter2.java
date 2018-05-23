package com.zhuye.ershoufang.adapter.home;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Common4Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class XinFangAdapter2 extends BaseMultiItemQuickAdapter<Common4Bean,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public XinFangAdapter2( List<Common4Bean> data) {
        super(data);
        addItemType(Common4Bean.TEXT, R.layout.home_xinfang_item);
        addItemType(Common4Bean.IMG, R.layout.home_xinfang_item2);
    }

    @Override
    protected void convert(BaseViewHolder helper, Common4Bean item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
//        helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²")
//        .setText(R.id.price,item.getPrice());

    }
}
