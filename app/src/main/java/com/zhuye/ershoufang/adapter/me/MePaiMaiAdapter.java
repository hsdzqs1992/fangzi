 package com.zhuye.ershoufang.adapter.me;

 import android.content.Context;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentPagerAdapter;

 import com.zhuye.ershoufang.R;
 import com.zhuye.ershoufang.ui.fragment.me.CommonMeQiTeFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeChuZuFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeMaiFangFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeQiTe1Fragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeQiTe2Fragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeQiTe3Fragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeQiTe4Fragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeQiTe5Fragment;

 import java.util.ArrayList;
 import java.util.List;

 /**
  * Created by Administrator on 2018/3/12 0012.
  */

 public class MePaiMaiAdapter extends FragmentPagerAdapter {

     Context mContext;
     String[] titles;
     List<CommonMeQiTeFragment> fragments = new ArrayList<>();
     public MePaiMaiAdapter(FragmentManager fm, Context context) {
         super(fm);
         mContext = context;
         titles = context.getResources().getStringArray(R.array.me_jingjiqit);
//         for(int i=0;i<titles.length;i++){
//             MePaiMaiFragment fragment = new MePaiMaiFragment();
//             fragments.add(fragment);
//         }
         fragments.add(new MeQiTe1Fragment());
         fragments.add(new MeMaiFangFragment());
         fragments.add(new MeQiTe2Fragment());
         fragments.add(new MeQiTe3Fragment());
         fragments.add(new MeQiTe4Fragment());
         fragments.add(new MeQiTe5Fragment());
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
