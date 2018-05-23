package com.zhuye.ershoufang.adapter.home;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.one.MyMultipleItem;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class ErFangAdapter2 extends BaseMultiItemQuickAdapter<MyMultipleItem<Common3Bean>,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ErFangAdapter2(List<MyMultipleItem<Common3Bean>> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultipleItem<Common3Bean> item) {

    }


//    @Override
//    protected void convert(BaseViewHolder helper, Common3Bean item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
//       // helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²");
//               // .setText(R.id.dizhi,item.get)
//    }
}
