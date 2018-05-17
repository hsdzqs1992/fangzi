package com.zhuye.ershoufang.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public abstract class CommonFragmentPagerAdapter extends FragmentPagerAdapter {


    Context mContext;
    protected String[] titles;
    protected List<BaseFragment> fragments = new ArrayList<>();

    public CommonFragmentPagerAdapter(FragmentManager fm, Context context,Integer resId) {
        super(fm);
        mContext = context;
        titles = context.getResources().getStringArray(resId);
//        for(int i=0;i<titles.length;i++){
//            MeMaiFAgnFragment fragment = new MeMaiFAgnFragment();
//            fragments.add(fragment);
//        }
      initFragments();
    }

    protected abstract void initFragments();

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
