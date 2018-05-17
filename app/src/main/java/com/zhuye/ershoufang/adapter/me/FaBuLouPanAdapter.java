package com.zhuye.ershoufang.adapter.me;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.LouPanBean;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.weidtet.MyGridLayoutManager;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class FaBuLouPanAdapter extends BaseQuickAdapter<LouPanBean,BaseViewHolder> {


    public FaBuLouPanAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, LouPanBean item) {
       ImageView pic =  helper.getView(R.id.pics);
       Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getImg()).into(pic);

       helper.setText(R.id.title,item.getTitle()).setText(R.id.diqu,item.getArea_name()+"-"+item.getBusiness_name())
               .setText(R.id.mianjiaa,"总建面 "+item.getMianji()+"m²")
               .setText(R.id.jiage,item.getPrice()+"元/m²").addOnClickListener(R.id.zhiding).addOnClickListener(R.id.edit);


        RecyclerView recyclerView = helper.getView(R.id.tese);
        LouFangItemAdapter adapter = new LouFangItemAdapter(R.layout.fabulou_item);
        recyclerView.setAdapter(adapter);
        MyGridLayoutManager myGridLayoutManager = new MyGridLayoutManager(mContext,5);
        recyclerView.setLayoutManager(myGridLayoutManager);
        myGridLayoutManager.setScrollEnabled(false);
       // adapter.addData(item.get);
    }
}
