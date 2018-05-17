package com.zhuye.ershoufang.ui.fragment;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.fabu.FaBuAdapter;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class FabuFragment extends BaseFragment {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @BindView(R.id.message_viewpager)
    ViewPager messageViewpager;
    Unbinder unbinder;

    @Override
    public void success(int requestcode, Base o) {

    }

    @Override
    protected void initView() {
        FaBuAdapter angAdapter = new FaBuAdapter(getChildFragmentManager(),getActivity());
        messageViewpager.setAdapter(angAdapter);
        viewpagertab.setViewPager(messageViewpager);
        hide(subtitle);
        hide(back);
        setText(ttitle,"新增委托");
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_fabu;
    }




}
