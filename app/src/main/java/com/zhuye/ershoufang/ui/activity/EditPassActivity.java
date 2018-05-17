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
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class EditPassActivity extends BaseActivity {

    private static final int EDIT = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.oldpass)
    EditText oldpass;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.repass)
    EditText repass;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.next)
    Button next;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_pass;
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"修改密码");

    }

    @OnClick({R.id.back, R.id.forget, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.forget:
                start(ForgetPass1Activity.class);
                break;
            case R.id.next:
                if(checkEmpty(oldpass,"请输入旧密码")&&
                        checkEmpty(pass,"请输入新密码")&&
                        checkEmpty(repass,"请再次输入新密码")){
                    if(!getString(pass).equals(getString(repass))){
                        toast("密码不一致");
                        return;
                    }
                    CommonApi.getInstance().modify_pass(SharedPreferencesUtil.getInstance().getString("token2"),
                            getString(oldpass),getString(pass),
                            EditPassActivity.this,EDIT);
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
