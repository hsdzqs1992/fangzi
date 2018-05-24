package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.utils.CheckUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class BaoJiaActivity extends BaseActivity {


    private static final int GETDATA = 1000;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.mianji)
    EditText mianji;
    @BindView(R.id.shouji)
    EditText shouji;
    @BindView(R.id.gujia)
    TextView gujia;

    @Override
    protected int getResId() {
        return R.layout.activity_bao_jia;
    }
    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"我的报价");

    }

    @OnClick({R.id.back, R.id.gujia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.gujia:
                if(checkEmpty(mianji,"请输入面积")&& CheckUtil.isMobile(BaoJiaActivity.this,getString(shouji))){
                    CommonApi.getInstance().guji(getString(mianji),getString(shouji),BaoJiaActivity.this,GETDATA);
                }
                break;
        }
    }


    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                toast(base.getMessage());
                start(BaoJia2Activity.class);
                break;
        }
    }
}
