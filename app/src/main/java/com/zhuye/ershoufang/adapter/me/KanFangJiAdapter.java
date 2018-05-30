package com.zhuye.ershoufang.adapter.me;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TvAdapter;
import com.zhuye.ershoufang.bean.KanFangBean;
import com.zhuye.ershoufang.data.NetWorkUrl;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class KanFangJiAdapter extends BaseQuickAdapter<KanFangBean,BaseViewHolder> {


    public KanFangJiAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, KanFangBean item) {
        ImageView imageVi = helper.getView(R.id.pics);
        Glide.with(mContext).load(NetWorkUrl.IMAGEURL+item.getPhoto()).into(imageVi);
        helper.setText(R.id.title,item.getTitle()).
                setText(R.id.dizhi,item.getAddr()).
                setText(R.id.price,item.getPrice())
                .setText(R.id.mianji,"总建面 "+item.getCount()+" m²");
        RecyclerView tesea = helper.getView(R.id.tese);
        TvAdapter adapter = new TvAdapter(R.layout.tv2);
        tesea.setAdapter(adapter);
        tesea.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        adapter.addData(item.getYoulie());
    }
}
