package com.zhuye.ershoufang.ui.fragment.home;

import com.zhuye.ershoufang.ui.activity.WebActivity;

public class HomeWenDadetailActivity extends WebActivity {


//    @Override
//    protected int getResId() {
//        return R.layout.activity_home_wen_dadetail;
//    }



    String id;
    @Override
    public String getUrlName() {
         id = getIntent().getStringExtra("id");
        return "wenda-detail";
    }

    @Override
    protected void javashoucang() {

    }

    @Override
    protected void initData() {
        super.initData();
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    @Override
    protected String getZiId() {
        return id;
    }
}
