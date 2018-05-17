package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class GuJiaActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.xiao)
    TextView xiao;
    @BindView(R.id.mi)
    TextView mi;
    @BindView(R.id.xing)
    TextView xing;
    @BindView(R.id.xiang)
    TextView xiang;
    @BindView(R.id.ceng)
    TextView ceng;
    @BindView(R.id.lookgujia)
    Button lookgujia;

    @Override
    protected int getResId() {
        return R.layout.activity_gu_jia;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"估算房价");
    }

    @OnClick({R.id.back, R.id.lookgujia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.lookgujia:
                break;
        }
    }
}
