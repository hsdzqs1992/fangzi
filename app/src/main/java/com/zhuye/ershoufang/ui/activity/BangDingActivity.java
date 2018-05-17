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
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class BangDingActivity extends BaseActivity {

    private static final int GETCODE = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.fasong)
    TextView fasong;
    @BindView(R.id.next)
    Button next;

    @Override
    protected int getResId() {
        return R.layout.activity_bang_ding;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"绑定手机号");
    }

    @OnClick({R.id.back, R.id.fasong, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.fasong:
                if (isEmpty(phone)) {
                    toast("请输入手机号");
                    return;
                }
                GetData.getCode3(getString(phone), BangDingActivity.this, GETCODE);
                break;
            case R.id.next:
                if(checkEmpty(phone,"请输入手机号码")
                        && checkEmpty(code,"请输入验证码")){
//                    start(JingJiRes3Activity.class,getString(loginname),getString(gongsi),getString(work));
//                      GetData.getRegeister(getString(loginname), getString(password),getString(repassword)
//                         ,getString(code),type,JingJiResActivity.this,REGEIST);
                    CommonApi.getInstance().bind_mobile(SharedPreferencesUtil.getInstance().getString("token2"),
                            getString(phone),getString(code),BangDingActivity.this,REGEIST);
                }
                break;
        }
    }
    private static final int REGEIST = 101;
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case GETCODE:
                toast(o.getMessage());
                break;

           case REGEIST:
                toast(o.getMessage());
                finish();
                //SharedPreferencesUtil.getInstance().putString("token",((LoginCode)o).getData().getToken());
                //leixing();
                break;
        }
    }
}
