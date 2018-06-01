package com.zhuye.ershoufang.ui.activity.home;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class XinFangDetailActivity extends WebActivity {

    private static final int SHOUCANG = 888;


    @Override
    public String getUrlName() {
        return "xinfang-detail";
    }

    @Override
    protected void javashoucang() {
        CommonApi.getInstance().collect(getToken(),"1",id,XinFangDetailActivity.this,COLLECT);
    }

    String id ="";


    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }


    @Override
    protected void getShareData() {
        super.getShareData();
        CommonApi.getInstance().share(id,"2",XinFangDetailActivity.this,SHARE,false);
    }

    @Override
    protected String getZiId() {
        return id;
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case SHOUCANG:
                toast(base.getMessage());
                break;
        }
    }
}
