 package com.zhuye.ershoufang.adapter.me;

 import android.content.Context;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentPagerAdapter;

 import com.zhuye.ershoufang.R;
 import com.zhuye.ershoufang.base.BaseFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeChuZuFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment11;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment22;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment33;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment44;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment55;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment66;
 import com.zhuye.ershoufang.ui.fragment.me.MeShouCangFragment77;

 import java.util.ArrayList;
 import java.util.List;

 /**
  * Created by Administrator on 2018/3/12 0012.
  */

 public class ShouCangAdapter2 extends FragmentPagerAdapter {

     Context mContext;
     String[] titles;
     List<BaseFragment> fragments = new ArrayList<>();
     public ShouCangAdapter2(FragmentManager fm, Context context) {
         super(fm);
         mContext = context;
         titles = context.getResources().getStringArray(R.array.me_shoucang);
//         for(int i=0;i<titles.length;i++){
//             MePaiMaiFragment fragment = new MePaiMaiFragment();
//             fragments.add(fragment);
//         }
         fragments.add(new MeShouCangFragment11());
         fragments.add(new MeShouCangFragment22());
         fragments.add(new MeShouCangFragment33());
         fragments.add(new MeShouCangFragment44());
         fragments.add(new MeShouCangFragment55());
         fragments.add(new MeShouCangFragment66());
         fragments.add(new MeShouCangFragment77());
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
