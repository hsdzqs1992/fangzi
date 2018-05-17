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

import butterknife.BindView;
import butterknife.OnClick;

public class AnswerActivity extends BaseActivity {


    private static final int TIJIAOA = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.tou)
    TextView tou;
    @BindView(R.id.shuru)
    EditText shuru;
    @BindView(R.id.tijiao)
    Button tijiao;

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"问题详情");
    }

    String id;
    String title;

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        tou.setText(title);
    }

    @Override
    protected int getResId() {
        return R.layout.activity_answer;
    }



    @OnClick({R.id.back, R.id.tijiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tijiao:
                if(checkEmpty(shuru,"请添加回答")){
                    CommonApi.getInstance().sub_answer(Integer.parseInt(id),getString(shuru),getToken(),AnswerActivity.this,TIJIAOA);
                }
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case TIJIAOA:
                toast(base.getMessage());
                // TODO: 2018/5/17 0017
               // setResult();
                finish();
                break;
        }
    }
}
