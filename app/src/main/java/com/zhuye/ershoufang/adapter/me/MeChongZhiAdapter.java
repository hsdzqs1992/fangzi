package com.zhuye.ershoufang.adapter.me;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.ZhiDingBean;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MeChongZhiAdapter extends BaseQuickAdapter<ZhiDingBean,BaseViewHolder> {


    public MeChongZhiAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhiDingBean item) {
            helper.setText(R.id.cishu,item.getNum()+"次置顶券")
            .setText(R.id.jiage,"售价 : ￥"+item.getMoney());
            ImageView select =  helper.getView(R.id.select);
            select.setVisibility(item.getChoose() ? View.VISIBLE: View.GONE);
    }
}
