package com.zhuye.ershoufang.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.ZiLiaoBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonInfoActivity extends BaseActivity {

    private static final int INFO = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.touxing)
    RoundedCornerImageView touxing;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.state)
    TextView state;
    @BindView(R.id.go)
    ImageView go;

    @Override
    protected int getResId() {
        return R.layout.activity_person_info;
    }


    @Override
    protected void initView() {
        super.initView();
        setText(ttitle,"个人资料");
        setText(subtitle,"编辑");
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().ziliao(SharedPreferencesUtil.getInstance().getString("token2"),this,INFO);
    }

    private Boolean wancheng = false;

    @OnClick({R.id.back, R.id.subtitle, R.id.go})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                //start(EditInfoActivity.class);
                wancheng = !wancheng;
                if(wancheng){


                }else {

                }
                break;
            case R.id.go:
                start(BangDingActivity.class);
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case INFO:
                ZiLiaoBean bean = (ZiLiaoBean) base;
                name.setText(bean.getData().getNickname());
                // String se = "男";
                 setText(sex,bean.getData().getSex().equals("1") ?  "男": "女");
                 setText(state,bean.getData().getSex().equals("1") ?  "已绑定": "未绑定");
                break;
        }
    }
}
