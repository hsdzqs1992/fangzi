package com.zhuye.ershoufang.ui.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.ShouCangAdapter;
import com.zhuye.ershoufang.ui.activity.common.CommonActivity;

public class KanFangJiluActivity extends CommonActivity {


    ShouCangAdapter adapter;
    @Override
    protected void initView() {
        super.initView();
        adapter = new ShouCangAdapter(R.layout.shoucang_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        hide(subtitle);
        setText(ttitle,"看房记录");
    }
}
