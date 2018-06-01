package com.zhuye.ershoufang.ui.fragment;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.TuiJianFragmentPagerAdapter;
import com.zhuye.ershoufang.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class TuiJianFragment extends BaseFragment {


    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.ershoufang)
    TextView ershoufang;
    @BindView(R.id.zufang)
    TextView zufang;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    @Override
    protected void initView() {
        TuiJianFragmentPagerAdapter adapter3 = new TuiJianFragmentPagerAdapter(getChildFragmentManager(),getActivity(),0);
        viewpager.setAdapter(adapter3);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_tuijian;
    }


    public void choose(TextView textView,TextView textView1,TextView textView2){
        int white = getResources().getColor(R.color.white);
        Drawable whitebg = getResources().getDrawable(R.drawable.shape_tuijian);
        int pramy = getResources().getColor(R.color.colorPrimary);
        Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);
        textView.setTextColor(pramy);
        textView.setBackground(whitebg);

        textView1.setTextColor(white);
        textView1.setBackground(pramybg);
        textView2.setTextColor(white);
        textView2.setBackground(pramybg);
    }

    @Override
    protected void initListener() {
        super.initListener();
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        //xinfang.setTextColor(pramy);
                        choose(xinfang,ershoufang,zufang);
                        break;
                    case 1:
                        choose(ershoufang,xinfang,zufang);
                        break;
                    case 2:
                        choose(zufang,ershoufang,xinfang);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick({R.id.xinfang, R.id.ershoufang, R.id.zufang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xinfang:
                viewpager.setCurrentItem(0);
                choose(xinfang,ershoufang,zufang);
                break;
            case R.id.ershoufang:
                choose(ershoufang,xinfang,zufang);
                viewpager.setCurrentItem(1);
                break;
            case R.id.zufang:
                choose(zufang,ershoufang,xinfang);
                viewpager.setCurrentItem(2);
                break;
        }
    }
}
