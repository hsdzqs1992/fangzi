package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.FangChanBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.ChangeMobile1Activity;
import com.zhuye.ershoufang.weidtet.MyInputView;

import butterknife.BindView;
import butterknife.OnClick;

public class MeFangChanCenterActivity extends BaseActivity {

    private static final int GETDATA = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.zhanghao)
    MyInputView zhanghao;
    @BindView(R.id.shenfenrenzh)
    MyInputView shenfenrenzh;
    @BindView(R.id.yingyezhizhao)
    MyInputView yingyezhizhao;

    @Override
    protected int getResId() {
        return R.layout.activity_me_fang_chan_center;

    }

    CommonObjectBean<FangChanBean> bean;
    @Override
    protected void initData() {
        super.initData();
        zhanghao.setRightArrow();
        zhanghao.nocanChange();
        CommonApi.getInstance().fangchandata(getToken(),MeFangChanCenterActivity.this,GETDATA);
    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonObjectBean<FangChanBean>) base;
                zhanghao.setContent(bean.getData().getAccount());
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"个人信息");
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


    @Override
    protected void initListener() {
        super.initListener();
        zhanghao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeFangChanCenterActivity.this,ChangeMobile1Activity.class);
                intent.putExtra("mobile",bean.getData().getAccount());
                startActivity(intent);
            }
        });
        shenfenrenzh.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeFangChanCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean.getData().getCard_img());
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        zhanghao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(MeFangChanCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean.getData().getLicense());
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });
    }
}
