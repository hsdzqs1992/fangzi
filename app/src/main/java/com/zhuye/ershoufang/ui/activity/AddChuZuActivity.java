package com.zhuye.ershoufang.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 新增出租住宅
 */
public class AddChuZuActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.mingcheng1)
    TextView mingcheng1;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.dianhuowu)
    LinearLayout dianhuowu;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.shoujia)
    EditText shoujia;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.shifa1)
    TextView shifa1;
    @BindView(R.id.mianji)
    EditText mianji;
    @BindView(R.id.mianjia)
    TextView mianjia;
    @BindView(R.id.dianshifa)
    RelativeLayout dianshifa;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.zhuangxiuchengdu)
    TextView zhuangxiuchengdu;
    @BindView(R.id.chaoxianga)
    TextView chaoxianga;
    @BindView(R.id.niandai)
    TextView niandai;
    @BindView(R.id.louceng)
    TextView louceng;
    @BindView(R.id.zujinyafu)
    TextView zujinyafu;
    @BindView(R.id.zulinfangshi)
    TextView zulinfangshi;
    @BindView(R.id.peizhi)
    RecyclerView peizhi;
    @BindView(R.id.xiaoqu)
    EditText xiaoqu;
    @BindView(R.id.youshi)
    EditText youshi;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.fabu)
    TextView fabu;
    @BindView(R.id.weituo)
    TextView weituo;

    @Override
    protected int getResId() {
        return R.layout.activity_add_chu_zu;
    }


    @OnClick({R.id.back, R.id.dianshifa, R.id.fangwuleixing, R.id.zhuangxiuchengdu, R.id.chaoxianga, R.id.niandai, R.id.louceng, R.id.zujinyafu, R.id.zulinfangshi, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.dianshifa:
                break;
            case R.id.fangwuleixing:
                break;
            case R.id.zhuangxiuchengdu:
                break;
            case R.id.chaoxianga:
                break;
            case R.id.niandai:
                break;
            case R.id.louceng:
                break;
            case R.id.zujinyafu:
                break;
            case R.id.zulinfangshi:
                break;
            case R.id.fabu:
                break;
            case R.id.weituo:
                break;
        }
    }
}
