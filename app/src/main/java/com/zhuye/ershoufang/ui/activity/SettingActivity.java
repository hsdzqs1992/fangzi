package com.zhuye.ershoufang.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.lianxi)
    RelativeLayout lianxi;
    @BindView(R.id.editpass)
    RelativeLayout editpass;
    @BindView(R.id.guanyu)
    RelativeLayout guanyu;
    @BindView(R.id.tuichu)
    RelativeLayout tuichu;
    @BindView(R.id.opens)
    ImageView opens;

    @Override
    protected int getResId() {
        return R.layout.activity_setting;
    }


    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "设置");
        hide(subtitle);

    }


    private Boolean open = true;

    @OnClick({R.id.back, R.id.lianxi, R.id.editpass, R.id.guanyu, R.id.tuichu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.lianxi:
                if(open){
                    opens.setImageResource(R.drawable.off);
                    open();
                }else {
                    opens.setImageResource(R.drawable.on);
                    close();
                }
                open = !open;
                break;
            case R.id.editpass:
                start(EditPassActivity.class);
                break;
            case R.id.guanyu:

                break;
            case R.id.tuichu:
                SharedPreferencesUtil.getInstance().putString("token2", "");
                start(LoginActivity.class, true);
                break;
        }
    }

    private void close() {

    }

    private void open() {

    }

}
