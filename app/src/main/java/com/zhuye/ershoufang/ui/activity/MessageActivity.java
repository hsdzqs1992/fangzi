package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MessageAdapter;
import com.zhuye.ershoufang.bean.XiaoXiBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import butterknife.BindView;
import butterknife.OnClick;

public class MessageActivity extends Common2Activity<XiaoXiBean> {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;


    @Override
    protected int getResId() {
        return R.layout.activity_message;
    }

    MessageAdapter adapter;

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "我的消息");

        adapter = new MessageAdapter(R.layout.message_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        CommonApi.getInstance().xiaoxi(getToken(),page,MessageActivity.this,LIST);
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.setWebViewClient(new ExampleWebViewClient());
////        webview.setWebChromeClient(new WebChromeClient(){
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                view.loadUrl(url);
////                return true;
////            }
////        });
//
//
//        webview.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().xiaoxi(getToken(),++page,MessageActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().xiaoxi(getToken(),1,MessageActivity.this,REFRESHBASE);
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MessageActivity.this,MessageDetailActivity.class);
                intent.putExtra("id",list.get(position).getXiaoxi_id());
                startActivity(intent);
            }
        });
    }
}
