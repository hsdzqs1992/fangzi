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
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.CheckUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPass1Activity extends BaseActivity {


    private static final int GETCODE = 100;
    private static final int CHECK = 101;
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
    @BindView(R.id.next)
    Button next;


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"忘记密码");
    }

    @Override
    protected int getResId() {
        return R.layout.activity_forget_pass1;
    }

    @OnClick({R.id.back, R.id.huoquyanzheng, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huoquyanzheng:
                if(CheckUtil.isMobile(ForgetPass1Activity.this,getString(loginname))){
                    GetData.getCode3(getString(loginname), ForgetPass1Activity.this, GETCODE);
                }
                break;
            case R.id.next:
                if(CheckUtil.isMobile(ForgetPass1Activity.this,getString(loginname))
                        && checkEmpty(code,"请输入验证码") ){
                    CommonApi.getInstance().forget(getString(loginname),getString(code),ForgetPass1Activity.this,CHECK);
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
            case CHECK:
                toast(o.getMessage());
                start(ForGetPass2Activity.class,getString(loginname));
                break;
//            case REGEIST:
//                toast(o.getMessage());
//                SharedPreferencesUtil.getInstance().putString("token",((LoginCode)o).getData().getToken());
//                leixing();
//                break;
        }
    }
}
