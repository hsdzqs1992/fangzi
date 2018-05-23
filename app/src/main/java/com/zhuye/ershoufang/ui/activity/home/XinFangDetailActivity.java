package com.zhuye.ershoufang.ui.activity.home;

import android.webkit.JavascriptInterface;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.ui.activity.WebActivity;

public class XinFangDetailActivity extends WebActivity {

    private static final int SHOUCANG = 888;

    @Override
    public String getUrlName() {
        return "xinfang-detail";
    }

    String id ="";


    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        webview.addJavascriptInterface(new AndroidBridge(), "java");
    }

    protected class AndroidBridge //这个类中提供各种js可调用的方法。
    {
        @JavascriptInterface
        public String getId()
        {
            return id;
//            handler.post(new Runnable(){
//                public void run()
//                {
//                    Log.d("ZW", "calAndroid("+arg+")");
//                    textView5.setText(arg);
//                }
//            });
        }

        @JavascriptInterface
        public String getToken1(){
            return getToken();
        }
        @JavascriptInterface
        public void toas(String content){
            toast(content);
        }

        @JavascriptInterface
        public void shoucang(){
           toast("shoucang");
            //CommonApi.getInstance().collect(getToken(),"1",id,XinFangDetailActivity.this,SHOUCANG);
            //// TODO: 2018/5/23 0023  
            webview.loadUrl("javascript:yishoucang()");
        }
        @JavascriptInterface
        public void share(){
            toast("share");
//            if(Thread.currentThread()== Looper.getMainLooper().getThread()){
//                Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//            }else {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
        }
        @JavascriptInterface
        public void chat(){
            toast("chat");
//            if(Thread.currentThread()== Looper.getMainLooper().getThread()){
//                Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//            }else {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(XinFangDetailActivity.this,"手长",Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
        }
        @JavascriptInterface
        public void callphone(){
           toast("callphone");
        }

        @JavascriptInterface
        public void callAndroid222(final String arg,final  String arg2)
        {
//            handler.post(new Runnable(){
//                public void run()
//                {
//                    Log.d("zwzw", "callAndroid222("+arg+","+arg2+")");
//                    textView5.setText(arg);
//                }
//            });
        }
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
