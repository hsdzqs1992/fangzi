package com.zhuye.ershoufang.adapter.home;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.FenLeiBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class HomefenleiAdapter extends BaseQuickAdapter<FenLeiBean.FenBean,BaseViewHolder> {

    public HomefenleiAdapter(int layoutResId) {
        super(layoutResId);
    }

    public HomefenleiAdapter(int layoutResId, @Nullable List<FenLeiBean.FenBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FenLeiBean.FenBean item) {
        helper.setImageResource(R.id.pic,item.imgRes).setText(R.id.name,item.stringRes);
    }
}
