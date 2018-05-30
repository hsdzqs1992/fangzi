package com.zhuye.ershoufang.city;

import android.content.Context;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseHolder;
import com.zhuye.ershoufang.base.BaseRecycleAdapter;


/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class HotAdapter extends BaseRecycleAdapter {


    public HotAdapter(Context conn) {
        super(conn);
    }

    @Override
    protected int getResId() {
        return R.layout.tv;
    }

    @Override
    protected void conver(BaseHolder holder, int position) {
        TextView tv = holder.getView(R.id.name);
        tv.setText(data.get(position)+"");
    }
}
