package com.zhuye.ershoufang.ui.activity;

public class AboutActivity extends WebActivity {

    @Override
    protected Boolean getFromLocal() {
        return false;
    }

    @Override
    public String getUrlName() {
        String  url = getIntent().getStringExtra("url");
        return url;
    }
}
