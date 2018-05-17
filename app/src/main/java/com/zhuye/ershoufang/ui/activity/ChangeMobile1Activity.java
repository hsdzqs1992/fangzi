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
import com.zhuye.ershoufang.utils.DaojinUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeMobile1Activity extends BaseActivity {


    private static final int GETCODE = 999;
    private static final int CHECK = 1000;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tou)
    RelativeLayout tou;
    @BindView(R.id.shoujihao)
    EditText shoujihao;
    @BindView(R.id.qian)
    ImageView qian;
    @BindView(R.id.yanzhengm)
    EditText yanzhengm;
    @BindView(R.id.huaquyanzhengma)
    TextView huaquyanzhengma;
    @BindView(R.id.zhecu)
    Button zhecu;

    @Override
    protected int getResId() {
        return R.layout.activity_change_mobile;
    }

    String  mobi;

    @Override
    protected void initData() {
        super.initData();
        mobi = getIntent().getStringExtra("mobile");
        shoujihao.setText(mobi);
    }

    @OnClick({R.id.back, R.id.huaquyanzhengma, R.id.zhecu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huaquyanzhengma:
                DaojinUtils.daojiShi(ChangeMobile1Activity.this,huaquyanzhengma);
                GetData.getCode3(mobi,ChangeMobile1Activity.this, GETCODE);
                break;
            case R.id.zhecu:
                String yanzheng = yanzhengm.getText().toString().trim();
                mobi = shoujihao.getText().toString().trim();
                if(isEmpty(mobi)){
                    toast("手机号不能为空");
                    return;
                }

                if(isEmpty(yanzheng)){
                    toast("验证码不能为空");
                    return;
                }

                if(!CheckUtil.isMobile(mobi)){
                    toast("手机号格式不正确");
                    return;
                }
                CommonApi.getInstance().change_mobile(mobi,yanzheng,ChangeMobile1Activity.this,CHECK);
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETCODE:
                toast(base.getMessage());
                break;
            case CHECK:
                start(ChangeMobile2Activity.class,true);
                break;
        }
    }
}
