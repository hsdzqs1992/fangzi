package com.zhuye.ershoufang.adapter.me;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.ui.fragment.MeMaiFAgnFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MaiFAngAdapter extends FragmentPagerAdapter {

    Context mContext;
    String[] titles;
    List<MeMaiFAgnFragment> fragments = new ArrayList<>();
    public MaiFAngAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        titles = context.getResources().getStringArray(R.array.me_maifang);
        for(int i=0;i<titles.length;i++){
            MeMaiFAgnFragment fragment = new MeMaiFAgnFragment();
            fragments.add(fragment);
        }
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

    public MeMaiFAgnFragment getCurrentItem(int index){
        switch (index){
            case 0:
                fragments.get(index).setId(3);
                break;
            case 1:
                fragments.get(index).setId(6);
                break;
            case 2:
                fragments.get(index).setId(7);
                break;
            case 3:
                fragments.get(index).setId(8);
                break;
        }
        return fragments.get(index);
    }
}
