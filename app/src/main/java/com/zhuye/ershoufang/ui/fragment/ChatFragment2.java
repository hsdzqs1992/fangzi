package com.zhuye.ershoufang.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.chat.MyFragmentWithMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class ChatFragment2 extends Fragment {

    View view;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;
    @BindView(R.id.frag)
    FrameLayout frag;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = View.inflate(getActivity(), getResId(), null);

        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    protected void initView() {
        back.setVisibility(View.GONE);
        subtitle.setVisibility(View.GONE);
        ttitle.setText("微聊");
    }


    protected int getResId() {
        return R.layout.fragment_chat;
    }

    FragmentManager fm;
    MyFragmentWithMap fragmentWithMap;
    protected void initData() {

        //Fragment fragment = initConversationList();
        // enterFragment();
        fm= getActivity().getSupportFragmentManager();
        fragmentWithMap=  new MyFragmentWithMap();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frag,fragmentWithMap);
        transaction.commit();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
