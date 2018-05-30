package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.ui.activity.WebActivity;

public class JingMaiDetailActivity2 extends WebActivity {

    @Override
    public String getUrlName() {
        return "jingmai-detail";
    }

    String  id ;

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
    }
}
