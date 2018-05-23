package com.zhuye.ershoufang.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.HomeJinBean;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.weidtet.MyGridLayoutManager;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class HomeJingJiAdapter extends BaseQuickAdapter<HomeJinBean,BaseViewHolder> {

    public HomeJingJiAdapter(int layoutResId) {
        super(layoutResId);
    }



    @Override
    protected void convert(BaseViewHolder helper,HomeJinBean item) {
        //helper.setImageResource(R.id.pic,item.imgRes).setText(R.id.name,item.stringRes);
        ImageView imageView = helper.getView(R.id.tou);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getFace()).into(imageView);

        helper.setText(R.id.name,item.getTrue_name()).setText(R.id.title,item.getArea_name()+"  "+item.getShop())
        .addOnClickListener(R.id.chat);


        RecyclerView recyclerView = helper.getView(R.id.youshi);
        YouShiAdapter adapter = new YouShiAdapter(R.layout.youshi_item);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new MyGridLayoutManager(mContext,4));
    }
}
