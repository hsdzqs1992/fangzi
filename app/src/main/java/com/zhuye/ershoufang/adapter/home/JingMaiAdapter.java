package com.zhuye.ershoufang.adapter.home;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.zhuye.ershoufang.adapter.CommonFragmentPagerAdapter;
import com.zhuye.ershoufang.ui.fragment.home.CommonXuQiuFragment;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class JingMaiAdapter extends CommonFragmentPagerAdapter{

    public JingMaiAdapter(FragmentManager fm, Context context, Integer resId) {
        super(fm, context, resId);
    }

    @Override
    protected void initFragments() {
        for (int i =0; i<titles.length;i++){
            fragments.add(new CommonXuQiuFragment());
        }
    }
}