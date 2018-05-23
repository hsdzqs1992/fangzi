package com.zhuye.ershoufang.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.ui.fragment.TuiJianViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/19 0019.
 */

public  class TuiJianFragmentPagerAdapter extends FragmentPagerAdapter {


    Context mContext;
    protected String[] titles;
    protected List<BaseFragment> fragments = new ArrayList<>();

    public TuiJianFragmentPagerAdapter(FragmentManager fm, Context context, Integer resId) {
        super(fm);
        mContext = context;
        fragments.add(new TuiJianViewFragment());
        fragments.add(new TuiJianViewFragment());
        fragments.add(new TuiJianViewFragment());
//        titles = context.getResources().getStringArray(resId);
//        for(int i=0;i<titles.length;i++){
//            MeMaiFAgnFragment fragment = new MeMaiFAgnFragment();
//            fragments.add(fragment);
//        }
//      initFragments();
    }

   // protected abstract void initFragments();

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titles[position];
//    }
}
