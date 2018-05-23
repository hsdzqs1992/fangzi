package com.zhuye.ershoufang.ui.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gyf.barlibrary.ImmersionBar;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;

public abstract class WebActivity extends BaseActivity {

    @BindView(R.id.webview)
    protected WebView webview;

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
        webview.loadUrl("file:///android_asset/"+getUrlName()+".html");
        //mImmersionBar = ImmersionBar.with(this);
       // mImmersionBar.init();   //所有子类都将继承这些相同的属性
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
        if (mImmersionBar != null){
            //mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进
        }
//        公用一个的处理
        webview.destroy();
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else {
            super.onBackPressed();
        }
    }


}
