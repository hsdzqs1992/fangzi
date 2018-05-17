package com.zhuye.ershoufang.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.CheckUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class HuiYuanResgeistActivity extends BaseActivity {

    private static final int GETCODE = 100;
    private static final int REGEIST = 101;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.loginname)
    EditText loginname;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.huoquyanzheng)
    TextView huoquyanzheng;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.next)
    Button next;

    @Override
    protected int getResId() {
        return R.layout.activity_hui_yuan_resgeist;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"普通会员注册");
    }

    @OnClick({R.id.back, R.id.huoquyanzheng, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huoquyanzheng:
                if (isEmpty(loginname)) {
                    toast("请输入手机号");
                    return;
                }
                if (CheckUtil.isMobile(getString(loginname))) {
                    toast("手机号格式有误");
                    return;
                }
                GetData.getCode3(getString(loginname),HuiYuanResgeistActivity.this, GETCODE);
                break;
            case R.id.next:
                if(checkEmpty(loginname,"请输入手机号码")
                        && checkEmpty(code,"请输入验证码")&&
                        checkEmpty(password,"请输入密码")
                        && checkEmpty(repassword,"请输入确认密码") ){
//                    start(JingJiRes3Activity.class,getString(loginname),getString(gongsi),getString(work));

                    if (CheckUtil.isMobile(getString(loginname))) {
                        toast("手机号格式有误");
                        return;
                    }

                    GetData.getRegeister(getString(loginname), getString(password),getString(repassword)
                            ,getString(code),0,HuiYuanResgeistActivity.this,REGEIST);
                }
                break;
        }
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case GETCODE:
                toast(o.getMessage());
                break;
            case REGEIST:
                toast(o.getMessage());
                start(LoginActivity.class,true);
                break;
        }
    }
}
