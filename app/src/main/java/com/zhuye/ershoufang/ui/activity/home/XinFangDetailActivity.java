package com.zhuye.ershoufang.ui.activity.home;

import android.webkit.WebView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;

public class XinFangDetailActivity extends BaseActivity {


    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected int getResId() {
        return R.layout.activity_xin_fang_detail;
    }

}
