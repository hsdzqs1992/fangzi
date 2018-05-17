package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/5/4 0004.
 */

public class MyFragmentTabHost extends FragmentTabHost {
    public MyFragmentTabHost(Context context) {
        super(context);
    }

    public MyFragmentTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onTouchModeChanged(boolean isInTouchMode) {

    }
}
