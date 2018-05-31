package com.zhuye.ershoufang.ui.activity.home;

import android.webkit.JavascriptInterface;

import com.zhuye.ershoufang.ui.activity.WebActivity;

public class ErShouFangDetailActivity extends WebActivity {

    @Override
    public String getUrlName() {
        return "ershou-detail";
    }

    @Override
    protected void javashoucang() {

    }

    String id ="";
    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    protected class AndroidBridge {
        @JavascriptInterface
        public String getId() {
            return id;
        }

        @JavascriptInterface
        public String getToken(){
            return getToken();
        }

        @JavascriptInterface
        public void callAndroid222(final String arg,final  String arg2) {
//            handler.post(new Runnable(){
//                public void run()
//                {
//                    Log.d("zwzw", "callAndroid222("+arg+","+arg2+")");
//                    textView5.setText(arg);
//                }
//          });
        }
    }
}
