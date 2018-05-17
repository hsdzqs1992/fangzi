package com.zhuye.ershoufang.adapter.me.qite;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.QiTeBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class QiTe4Adapter extends BaseQuickAdapter<QiTeBean,BaseViewHolder> {


    public QiTe4Adapter(int layoutResId) {
        super(layoutResId);
    }

    // T
    @Override
    protected void convert(BaseViewHolder helper, QiTeBean item) {
        helper.setText(R.id.title,item.getTitle());

        TextView jingjiren =  helper.getView(R.id.jingjiren);
        TextView mobile =  helper.getView(R.id.mobile);

        if(item.getAgent().equals("")){
            jingjiren.setVisibility(View.GONE);
            mobile.setVisibility(View.GONE);
        }else {
            jingjiren.setText("经纪人 ： "+ item.getAgent());
            mobile.setText(item.getAgent_mobile());
        }
    }
}
