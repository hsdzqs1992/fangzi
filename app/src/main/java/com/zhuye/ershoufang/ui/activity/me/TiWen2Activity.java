package com.zhuye.ershoufang.ui.activity.me;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class TiWen2Activity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.wenti)
    EditText wenti;
    @BindView(R.id.miaoshu)
    EditText miaoshu;
    @BindView(R.id.tiwen)
    Button tiwen;

    @Override
    protected int getResId() {
        return R.layout.activity_ti_wen2;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"提问");

    }

    @OnClick({R.id.back, R.id.tiwen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tiwen:
                if(checkEmpty(wenti,"请输入您的问题")){
                    CommonApi.getInstance().questionfabu(SharedPreferencesUtil.getInstance().getString("token2"),
                            getString(wenti),getString(miaoshu),TiWen2Activity.this,ADD);
                }
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        toast(base.getMessage());
        finish();
    }
}
