 package com.zhuye.ershoufang.adapter.me;

 import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.ui.fragment.me.MePaiMai2Fragment;

import java.util.ArrayList;
import java.util.List;

 /**
  * Created by Administrator on 2018/3/12 0012.
  */

 public class MyPaiMai2Adapter extends FragmentPagerAdapter {

     Context mContext;
     String[] titles;
     List<MePaiMai2Fragment> fragments = new ArrayList<>();
     public MyPaiMai2Adapter(FragmentManager fm, Context context) {
         super(fm);
         mContext = context;
         titles = context.getResources().getStringArray(R.array.me_paimai2);
         for(int i=0;i<titles.length;i++){
             MePaiMai2Fragment fragment = new MePaiMai2Fragment();
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

     public MePaiMai2Fragment getCurrentItem(int index){
         switch (index){
             case 0:
                 fragments.get(index).setId(1);
                 break;
             case 1:
                 fragments.get(index).setId(2);
                 break;
             case 2:
                 fragments.get(index).setId(3);
                 break;
             case 3:
                 fragments.get(index).setId(4);
                 break;
         }

         return fragments.get(index);
//         return null;
     }
 }
