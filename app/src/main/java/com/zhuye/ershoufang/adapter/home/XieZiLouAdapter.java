package com.zhuye.ershoufang.adapter.home;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.ui.fragment.home.CommonXieZiFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class XieZiLouAdapter extends FragmentPagerAdapter {


    Context mContext;
    String[] titles;
    List<BaseFragment> fragments = new ArrayList<>();

    public XieZiLouAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        titles = context.getResources().getStringArray(R.array.home_xiezilou_tab);
//        for(int i=0;i<titles.length;i++){
//            MeMaiFAgnFragment fragment = new MeMaiFAgnFragment();
//            fragments.add(fragment);
//        }
        fragments.add(new CommonXieZiFragment());
        fragments.add(new CommonXieZiFragment());
    }
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
