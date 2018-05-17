package com.zhuye.ershoufang.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.CheckUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeMobile2Activity extends BaseActivity {

    private static final int GETCODE = 999;
    private static final int CHECK = 1000;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tou)
    RelativeLayout tou;
    @BindView(R.id.shoujihao)
    EditText shoujihao;
    @BindView(R.id.yanzhengm)
    EditText yanzhengm;
    @BindView(R.id.huaquyanzhengma)
    TextView huaquyanzhengma;
    @BindView(R.id.queding)
    Button queding;

    @Override
    protected int getResId() {
        return R.layout.activity_change_mobile2;
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETCODE:
                toast(base.getMessage());
                break;
            case CHECK:
                //start(ChangeMobile2Activity.class);
                toast(base.getMessage());
                finish();
                break;
        }
    }

    @OnClick({R.id.back, R.id.huaquyanzhengma, R.id.queding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huaquyanzhengma:
                fasong();
                break;
            case R.id.queding:
                String yanzheng = yanzhengm.getText().toString().trim();
                final String mobil = shoujihao.getText().toString().trim();
                if(isEmpty(mobil)){
                    toast("手机号不能为空");
                    return;
                }
                if(!CheckUtil.isMobile(mobil)){
                    toast("手机号格式不正确");
                    return;
                }
                if(isEmpty(yanzheng)){
                    toast("验证码不能为空");
                    return;
                }

                CommonApi.getInstance().new_mobile(getToken(),mobil,yanzheng,ChangeMobile2Activity.this,CHECK);
               // GetData.new_mobile(SharedPreferencesUtil.getInstance().getString("token"),mobil,yanzheng,ChangeMobile2Activity.this,YANZHENG);
                break;
        }
    }

    private void fasong() {
        String mobile =  shoujihao.getText().toString().trim();
        if(CheckUtil.isMobile(ChangeMobile2Activity.this,mobile)){
            GetData.getCode3(mobile,ChangeMobile2Activity.this, GETCODE);
        }

    }
}
