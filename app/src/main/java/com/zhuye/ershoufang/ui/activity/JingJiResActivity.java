package com.zhuye.ershoufang.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.LoginCode;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.CheckUtil;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingJiResActivity extends BaseActivity {

    private static final int GETCODE = 100;
    private static final int REGEIST = 101;
    @BindView(R.id.huoquyanzheng)
    TextView huoquyanzheng;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.loginname)
    EditText loginname;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repassword)
    EditText repassword;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;

    @Override
    protected int getResId() {
        return R.layout.activity_jing_ji_res;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @OnClick({R.id.back,R.id.huoquyanzheng, R.id.next})
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

                GetData.getCode3(getString(loginname), JingJiResActivity.this, GETCODE);
                break;
            case R.id.next:
                // start(JingJIRes2Activity.class);
                if (checkEmpty(loginname, "请输入手机号码")
                        && checkEmpty(code, "请输入验证码") &&
                        checkEmpty(password, "请输入密码")
                        && checkEmpty(repassword, "请输入确认密码")) {
//                    start(JingJiRes3Activity.class,getString(loginname),getString(gongsi),getString(work));

                    if (CheckUtil.isMobile(getString(loginname))) {
                        toast("手机号格式有误");
                        return;
                    }

                    GetData.getRegeister(getString(loginname), getString(password), getString(repassword)
                            , getString(code), type, JingJiResActivity.this, REGEIST);
                }
                // leixing();
                break;
        }
    }

    Integer type;

    @Override
    protected void initData() {
        super.initData();
        type = (Integer) getTData(1, 0);
        --type;
        hide(subtitle);
        switch (type){
            case 1:
                setText(ttitle,"经纪人注册");
                break;
            case 2:
                setText(ttitle,"房产商注册");
                break;
            case 3:
                setText(ttitle,"家具商注册");
                break;
            case 4:
                setText(ttitle,"装修公司注册");
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
                SharedPreferencesUtil.getInstance().putString("token", ((LoginCode) o).getData().getToken());
                leixing();
                break;
        }
    }

    private void leixing() {
        switch (type) {
            case 1:
                start(JingJIRes2Activity.class);
                break;
            case 2:
            case 3:
            case 4:
                start(OthersRes3Activity.class, type + "");
                break;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
