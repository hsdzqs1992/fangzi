package com.zhuye.ershoufang.one;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.Common5Bean;
import com.zhuye.ershoufang.data.NetWorkUrl;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class XinFangAdapter3 extends BaseMultiItemQuickAdapter<MyMultipleItem<Common5Bean>,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public XinFangAdapter3(List<MyMultipleItem<Common5Bean>> data) {
        super(data);
        addItemType(MyMultipleItem.FIRST_TYPE, R.layout.home_xinfang_item);
        addItemType(MyMultipleItem.SECOND_TYPE, R.layout.home_xinfang_item2);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultipleItem<Common5Bean> item) {
//        ImageView imageView = helper.getView(R.id.pics);
//        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageView);
//        helper.setText(R.id.title,item.getTitle()).setText(R.id.mianji,"总建面 "+item.getMianji()+" m²")
//        .setText(R.id.price,item.getPrice());

        switch (item.getItemType()){
            case MyMultipleItem.FIRST_TYPE:
                ImageView imageVi = helper.getView(R.id.pics);
//                if(item.getData().getPhoto()==null&&item.getData().getPhoto().size()>1) {
//                    Glide.with(mContext).load(NetWorkUrl.IMAGEURL + item.getData().getPhoto().get(0)).into(imageVi);
//                }
                Glide.with(mContext).load(NetWorkUrl.IMAGEURL + item.getData().getPhoto().get(0)).into(imageVi);
                helper.setText(R.id.title,item.getData().getTitle()).
                        setText(R.id.dizhi,item.getData().getArea()+"-"+item.getData().getBusiness())
                        .setText(R.id.price,item.getData().getPrice())
                        .setText(R.id.mianji,"总建面 "+item.getData().getMianji()+" m²");
                RecyclerView tesea = helper.getView(R.id.tese);
                TvAdapter adapter = new TvAdapter(R.layout.tv2);
                tesea.setAdapter(adapter);
                tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
              //  adapter.addData(item.getData().get);
                break;
            case MyMultipleItem.SECOND_TYPE:
                helper.setText(R.id.name,item.getData().getTitle()).
                        setText(R.id.dizhi2,item.getData().getArea()+"-"+item.getData().getBusiness())
                        .setText(R.id.jiage,item.getData().getPrice())
                        .setText(R.id.mianji2,"总建面 "+item.getData().getMianji()+" m²");

                ImageView imageView = helper.getView(R.id.pics);
                ImageView imageView1 = helper.getView(R.id.pics1);
                ImageView imageView2 = helper.getView(R.id.pics2);
                Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getData().getPhoto().get(0)).into(imageView);
                Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getData().getPhoto().get(1)).into(imageView1);
                Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getData().getPhoto().get(2)).into(imageView2);

                RecyclerView tese = helper.getView(R.id.tese);

                break;
        }

    }
}
