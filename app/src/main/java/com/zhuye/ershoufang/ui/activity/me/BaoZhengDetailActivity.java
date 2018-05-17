package com.zhuye.ershoufang.ui.activity.me;

import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.DaiBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.OnClick;

public class BaoZhengDetailActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.jingjiren)
    TextView jingjiren;
    @BindView(R.id.mobile)
    TextView mobile;

    @Override
    protected int getResId() {
        return R.layout.activity_bao_zheng_detail;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"详情");
        String id = getIntent().getStringExtra("id");
        CommonApi.getInstance().daikuan_detail(id,BaoZhengDetailActivity.this,INIT);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case INIT:
                // TODO: 2018/5/9 0009  可能是个列表
                CommonObjectBean<DaiBean> bean = (CommonObjectBean<DaiBean>) base;
                setText(title,bean.getData().getTitle());
                setText(jingjiren,bean.getData().getJd_name());
                setText(mobile,bean.getData().getJd_mobile());
                break;
        }
    }
}
