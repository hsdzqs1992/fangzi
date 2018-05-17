package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public class MyGridLayoutManager extends GridLayoutManager {

    public MyGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }
    private boolean isScrollEnabled = true;

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}
