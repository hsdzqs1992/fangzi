package com.zhuye.ershoufang.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.XiaoXiBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageDetailActivity extends BaseActivity {


    private static final int GETDATAU = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.content)
    TextView content;

    @Override
    protected int getResId() {
        return R.layout.activity_message_detail;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"详情");
    }


    @Override
    public void success(int requestcode, Base base) {
        switch (requestcode){
            case GETDATAU:
                CommonObjectBean<XiaoXiBean> bean = (CommonObjectBean<XiaoXiBean>) base;
                setText(time,bean.getData().getCreate_time());
                content.setText(bean.getData().getMessage());
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        String id = getIntent().getStringExtra("id");
        CommonApi.getInstance().xx_detail(id,MessageDetailActivity.this,GETDATAU);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
