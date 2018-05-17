 package com.zhuye.ershoufang.adapter.home;

 import android.content.Context;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentPagerAdapter;

 import com.zhuye.ershoufang.R;
 import com.zhuye.ershoufang.ui.fragment.home.WenDaFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeChuZuFragment;

 import java.util.ArrayList;
 import java.util.List;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class HomeWendaAdapter extends FragmentPagerAdapter {

    Context mContext;
    String[] titles;
    List<WenDaFragment> fragments = new ArrayList<>();
    public HomeWendaAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        titles = context.getResources().getStringArray(R.array.home_wenda);
        for(int i=0;i<titles.length;i++){
            WenDaFragment fragment = new WenDaFragment();
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

    public MeChuZuFragment getCurrentItem(int index){
//        switch (index){
//            case 0:
//                fragments.get(index).setId(3);
//                break;
//            case 1:
//                fragments.get(index).setId(6);
//                break;
//            case 2:
//                fragments.get(index).setId(7);
//                break;
//            case 3:
//                fragments.get(index).setId(8);
//                break;
//        }
//        return fragments.get(index);
        return null;
    }
}
