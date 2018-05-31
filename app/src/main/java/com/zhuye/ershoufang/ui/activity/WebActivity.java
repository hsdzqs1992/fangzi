package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public abstract class WebActivity extends BaseActivity {

    private static final int YOUHUI = 988;
    @BindView(R.id.webview)
    protected WebView webview;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.root)
    LinearLayout root;

    @Override
    protected int getResId() {
        return R.layout.activity_web;
    }

    private ImmersionBar mImmersionBar;

    @Override
    protected void initView() {
        super.initView();
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

//        webview.loadUrl("file:///android_asset/index.html");

        webview.setWebViewClient(new ExampleWebViewClient());


        if(getFromLocal()){
            webview.loadUrl("file:///android_asset/" + getUrlName() + ".html");
        }else {
            webview.loadUrl(getUrlName());
        }
        root.setVisibility(View.GONE);
        //mImmersionBar = ImmersionBar.with(this);
        // mImmersionBar.init();   //所有子类都将继承这些相同的属性
    }

    protected Boolean getFromLocal() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class ExampleWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    }

    public abstract String getUrlName();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            //mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进
        }
//        公用一个的处理
        webview.destroy();
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }


    private UMShareListener  umShareListener = new UMShareListener(){
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            LogUtils.i(share_media.toString());
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            LogUtils.i(throwable.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    };

    public class AndroidBridge //这个类中提供各种js可调用的方法。
    {
        @JavascriptInterface
        public String getId()
        {
            return getZiId();
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
            
            javashoucang();
            webview.loadUrl("javascript:yishoucang()");
        }
        @JavascriptInterface
        public void share(){
            toast("share");

            new ShareAction(WebActivity.this).withText("hello")
                    .setDisplayList(SHARE_MEDIA.QZONE,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                    .setCallback(umShareListener).open();

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
        public String getBase(){
            return getBaseUrl();
        }

        @JavascriptInterface
        public void chat(String id){
            toast(id+"");
            RongIM.getInstance().startConversation(WebActivity.this
                    , Conversation.ConversationType.PRIVATE,"93","");
        }

        @JavascriptInterface
        public void chat(){
            // toast(totoken);
            toast("chat");
//            RongIM.getInstance().startConversation(XinFangDetailActivity.this
//            ,Conversation.ConversationType.PRIVATE,totoken,"sadfasdf");

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

        @JavascriptInterface
        public void youhui(String number){
            CommonApi.getInstance().discount(getToken(),getZiId(),number,WebActivity.this,YOUHUI);
        }
    }

    protected abstract void javashoucang();


    protected String getZiId() {
        return "1";
    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case YOUHUI:
                toast(base.getMessage());
                break;
        }
    }

    public String getBaseUrl(){
        return NetWorkUrl.BASE;
    }
    public String getBaseUrlImg(){
        return NetWorkUrl.IMG;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
