package com.zhuye.ershoufang.ui.activity.me;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.FanZiDetail;
import com.zhuye.ershoufang.data.CommonApi;

import butterknife.BindView;
import butterknife.OnClick;

public class EditErShouActivity extends BaseActivity {


    private static final int GETDATA = 200;
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
    @BindView(R.id.xiaoqu)
    EditText xiaoqu;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.zhuangxiuleixing)
    TextView zhuangxiuleixing;
    @BindView(R.id.niamdai)
    TextView niamdai;
    @BindView(R.id.danyuan)
    TextView danyuan;
    @BindView(R.id.cneg)
    TextView cneg;
    @BindView(R.id.shoufu2)
    TextView shoufu2;
    @BindView(R.id.shoufu)
    RelativeLayout shoufu;
    @BindView(R.id.fangjia1)
    TextView fangjia1;
    @BindView(R.id.fangjia)
    RelativeLayout fangjia;
    @BindView(R.id.yuegong1)
    TextView yuegong1;
    @BindView(R.id.yuegong)
    RelativeLayout yuegong;
    @BindView(R.id.chaoxiang1)
    TextView chaoxiang1;
    @BindView(R.id.chaoxiang)
    RelativeLayout chaoxiang;
    @BindView(R.id.modi1)
    TextView modi1;
    @BindView(R.id.modi2)
    EditText modi2;
    @BindView(R.id.youshi)
    RelativeLayout youshi;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.maidian)
    EditText maidian;
    @BindView(R.id.xintai)
    EditText xintai;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.huxingtu)
    RecyclerView huxingtu;
    @BindView(R.id.huanjing)
    RecyclerView huanjing;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.weituo)
    Button weituo;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_er_shou;
    }

    @Override
    protected void initData() {
        super.initData();
        String life_id = getIntent().getStringExtra("life_id");
        CommonApi.getInstance().view(Integer.parseInt(life_id), EditErShouActivity.this, GETDATA);
    }

    FanZiDetail fanZiDetail;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                fanZiDetail = (FanZiDetail) base;
                title.setText(fanZiDetail.getData().getTitle());
                break;
        }
    }


    @OnClick({R.id.back, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.fabu:
                break;
            case R.id.weituo:
                break;
        }
    }
}
