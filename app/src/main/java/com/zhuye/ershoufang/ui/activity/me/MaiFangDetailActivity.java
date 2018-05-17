package com.zhuye.ershoufang.ui.activity.me;

import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.MaiChuBean;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.OnClick;

public class MaiFangDetailActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.xiaoqu)
    TextView xiaoqu;
    @BindView(R.id.mianji)
    TextView mianji;
    @BindView(R.id.huxing)
    TextView huxing;
    @BindView(R.id.shoujia)
    TextView shoujia;
    @BindView(R.id.menpai)
    TextView menpai;
    @BindView(R.id.louceng)
    TextView louceng;
    @BindView(R.id.leixing)
    TextView leixing;
    @BindView(R.id.zhuangxiu)
    TextView zhuangxiu;
    @BindView(R.id.chaoxiang)
    TextView chaoxiang;
    @BindView(R.id.weituoren)
    TextView weituoren;

    @Override
    protected int getResId() {
        return R.layout.activity_mai_fang_detail;
    }


    @Override
    protected void initData() {
        super.initData();  // {"data":"","message":"\u65e0\u6b64\u59d4\u6258\u4fe1\u606f","code":"201"}
        String id = getIntent().getStringExtra("id");
        CommonApi.getInstance().phose_detail(id,this,INIT);
        setText(ttitle,"详情");
        hide(subtitle);
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
                CommonObjectBean<MaiChuBean>  fang = (CommonObjectBean<MaiChuBean>) base;
                setText(xiaoqu,fang.getData().getXiaoqu());
                setText(mianji,fang.getData().getNum1()+"m²");
                setText(huxing,fang.getData().getHuxing());
                setText(shoujia,fang.getData().getNum2()+"万元");

                setText(menpai,fang.getData().getHuxing());
                setText(louceng,fang.getData().getLouceng());

                setText(leixing,fang.getData().getSelect1());
                setText(zhuangxiu,fang.getData().getSelect2());
                setText(chaoxiang,fang.getData().getSelect3());
                setText(weituoren,fang.getData().getContact()+fang.getData().getMobile());
                break;
        }
    }
}
