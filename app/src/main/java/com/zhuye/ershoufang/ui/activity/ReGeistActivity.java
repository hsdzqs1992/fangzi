package com.zhuye.ershoufang.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.utils.ChoicesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReGeistActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.huiyuana)
    ImageView huiyuana;
    @BindView(R.id.jingjirenga)
    ImageView jingjirenga;
    @BindView(R.id.fangchanshanga)
    ImageView fangchanshanga;
    @BindView(R.id.jiajua)
    ImageView jiajua;
    @BindView(R.id.zhuangxiua)
    ImageView zhuangxiua;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;

    @Override
    protected int getResId() {
        return R.layout.activity_re_geist;
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initData() {
        super.initData();
        hide(subtitle);

        ChoicesUtils.type = 0;
        ChoicesUtils.count = 5;
        ChoicesUtils.choiceView.add(huiyuana);
        ChoicesUtils.choiceView.add(jingjirenga);
        ChoicesUtils.choiceView.add(fangchanshanga);
        ChoicesUtils.choiceView.add(jiajua);
        ChoicesUtils.choiceView.add(zhuangxiua);

        ChoicesUtils.choiceid.add(R.drawable.huiyuan);
        ChoicesUtils.choiceid.add(R.drawable.jingjirengray);
        ChoicesUtils.choiceid.add(R.drawable.fangchanshang);
        ChoicesUtils.choiceid.add(R.drawable.jiaju);
        ChoicesUtils.choiceid.add(R.drawable.zhuangxiu);

        ChoicesUtils.choiceselView.add(R.drawable.huiyuanlan);
        ChoicesUtils.choiceselView.add(R.drawable.jinjiren);
        ChoicesUtils.choiceselView.add(R.drawable.fangchanchanglan);
        ChoicesUtils.choiceselView.add(R.drawable.jiajulan);
        ChoicesUtils.choiceselView.add(R.drawable.zhuangxiulan);
    }

    //处理单选的逻辑

    private int pos = 0;

    @OnClick({R.id.back, R.id.huiyuana, R.id.jingjirenga, R.id.fangchanshanga, R.id.jiajua, R.id.zhuangxiua, R.id.next})
    public void onViewClicked(View view) {
        ChoicesUtils.clear();
        initData();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.huiyuana:
                //todo bug 有问题
                ChoicesUtils.type = 1;
                pos = 1;
                ChoicesUtils.change();
                break;
            case R.id.jingjirenga:
                ChoicesUtils.type = 2;
                pos = 2;
                ChoicesUtils.change();
                break;
            case R.id.fangchanshanga:
                ChoicesUtils.type = 3;
                pos = 3;
                ChoicesUtils.change();
                break;
            case R.id.jiajua:
                ChoicesUtils.type = 4;
                pos = 4;
                ChoicesUtils.change();
                break;
            case R.id.zhuangxiua:
                ChoicesUtils.type = 5;
                pos = 5;
                ChoicesUtils.change();
                break;
            case R.id.next:
                if (pos == 0) {
                    toast("请选择身份");
                    return;
                }
                jumpZhuCe();
                break;
        }
    }


    private void jumpZhuCe() {
        switch (pos) {
            case 1:
                //会员
                start(HuiYuanResgeistActivity.class, 1 + "");
                break;
            case 2:
//经纪人
                start(JingJiResActivity.class, 2 + "");
                break;
            case 3:
                start(JingJiResActivity.class, 3 + "");
                break;
            case 4:
                start(JingJiResActivity.class, 4 + "");
                break;
            case 5:
                start(JingJiResActivity.class, 5 + "");
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
