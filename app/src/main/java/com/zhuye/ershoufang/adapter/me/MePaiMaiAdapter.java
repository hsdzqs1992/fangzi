 package com.zhuye.ershoufang.adapter.me;

 import android.content.Context;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentPagerAdapter;

 import com.zhuye.ershoufang.R;
 import com.zhuye.ershoufang.adapter.me.paimai.BaoZhengFragment;
 import com.zhuye.ershoufang.adapter.me.paimai.CanYuFragment;
 import com.zhuye.ershoufang.adapter.me.paimai.MeTiXingFragment;
 import com.zhuye.ershoufang.adapter.me.paimai.YiPaiFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MeChuZuFragment;
 import com.zhuye.ershoufang.ui.fragment.me.MePaiMaiFragment;

 import java.util.ArrayList;
 import java.util.List;

 /**
  * Created by Administrator on 2018/3/12 0012.
  */

 public class MePaiMaiAdapter extends FragmentPagerAdapter {

     Context mContext;
     String[] titles;
     List<MePaiMaiFragment> fragments = new ArrayList<>();
     public MePaiMaiAdapter(FragmentManager fm, Context context) {
         super(fm);
         mContext = context;
         titles = context.getResources().getStringArray(R.array.me_paimai);
//         for(int i=0;i<titles.length;i++){
//             MePaiMaiFragment fragment = new MePaiMaiFragment();
//             fragments.add(fragment);
//         }
         fragments.add(new CanYuFragment());
         fragments.add(new YiPaiFragment());
         fragments.add(new BaoZhengFragment());
         fragments.add(new MeTiXingFragment());
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
