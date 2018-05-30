package com.zhuye.ershoufang.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.ChatAdapter;
import com.zhuye.ershoufang.base.BaseFragment;
import com.zhuye.ershoufang.bean.Base;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class ChatFragment extends BaseFragment {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;

    @Override
    public void success(int requestcode, Base o) {

    }

    @Override
    protected void initView() {
        hide(back);
        hide(subtitle);
        setText(ttitle,"微聊");
    }


    @Override
    protected void initData() {
        super.initData();
        adapte = new ChatAdapter(R.layout.chat_item);
        recycle.setAdapter(adapte);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getResId() {
        return R.layout.common;
    }



}
