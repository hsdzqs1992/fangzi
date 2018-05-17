package com.zhuye.ershoufang.adapter.fabu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.BanZhengFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.ChuZuFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.DaiKuanFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.Mai2FangFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.MaiFangFragment;
import com.zhuye.ershoufang.ui.fragment.fabu.QiuZuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class FaBuAdapter extends FragmentPagerAdapter {

    Context mContext;
    String[] titles;
    List<BaseFragment> fragments = new ArrayList<>();
    public FaBuAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        titles = context.getResources().getStringArray(R.array.home_fabu);
//        for(int i=0;i<titles.length;i++){
//            MeMaiFAgnFragment fragment = new MeMaiFAgnFragment();
//            fragments.add(fragment);
//        }
        fragments.add(new MaiFangFragment());
        fragments.add(new Mai2FangFragment());
        fragments.add(new ChuZuFragment());
        fragments.add(new QiuZuFragment());
        fragments.add(new BanZhengFragment());
        fragments.add(new DaiKuanFragment());
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
