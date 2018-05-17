package com.zhuye.ershoufang.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.OnClick;

public class ForGetPass2Activity extends BaseActivity {


    private static final int SUB = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.loginname)
    EditText loginname;
    @BindView(R.id.reloginname)
    EditText reloginname;
    @BindView(R.id.next)
    Button next;

    @Override
    protected int getResId() {
        return R.layout.activity_for_get_pass2;
    }

String phone;
    @Override
    protected void initView() {
        super.initView();
        setText(ttitle,"忘记密码");
        hide(subtitle);
        phone = (String) getTData(0,0);
    }


    @OnClick({R.id.back, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.next:
                if(checkEmpty(loginname,"请输入您的新密码")&&checkEmpty(reloginname,"请再次输入您的新密码")){
                    if(!getString(loginname).equals(getString(reloginname))){
                        toast("密码不一致");
                        return;
                    }
                    CommonApi.getInstance().set_passport(phone,getString(loginname),ForGetPass2Activity.this,SUB);
                }
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        toast(base.getMessage());
        start(LoginActivity.class,true);
    }
}
