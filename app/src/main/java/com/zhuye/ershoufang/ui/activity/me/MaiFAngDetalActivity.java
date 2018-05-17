package com.zhuye.ershoufang.ui.activity.me;

import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.FangZiBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.OnClick;

public class MaiFAngDetalActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.mianji)
    TextView mianji;
    @BindView(R.id.huxing)
    TextView huxing;
    @BindView(R.id.shoujia)
    TextView shoujia;
    @BindView(R.id.menpai)
    TextView menpai;

    @Override
    protected int getResId() {
        return R.layout.activity_mai_fang_detal;
    }


    @Override
    protected void initData() {
        super.initData();
        hide(subtitle);
        setText(ttitle,"详情");

        String id = getIntent().getStringExtra("id");
        CommonApi.getInstance().mall_detail(id,this,INIT);
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
                CommonObjectBean<FangZiBean> bean = (CommonObjectBean<FangZiBean>) base;
                setText(huxing,bean.getData().getHuxing());
                setText(shoujia,bean.getData().getXiaoqu());
                setText(mianji,bean.getData().getNum1());
                setText(menpai,bean.getData().getNum2());
                break;
        }
    }
}
