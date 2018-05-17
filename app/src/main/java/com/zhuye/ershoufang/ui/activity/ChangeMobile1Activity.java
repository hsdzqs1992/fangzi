package com.zhuye.ershoufang.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangeMobile1Activity extends BaseActivity {


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


    @OnClick({R.id.back, R.id.huaquyanzhengma, R.id.zhecu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huaquyanzhengma:

                break;
            case R.id.zhecu:

                break;
        }
    }
}
