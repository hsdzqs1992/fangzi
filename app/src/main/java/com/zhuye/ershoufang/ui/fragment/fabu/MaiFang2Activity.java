package com.zhuye.ershoufang.ui.fragment.fabu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.SelectCityActivity;
import com.zhuye.ershoufang.utils.CheckUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MaiFang2Activity extends SelectCityActivity {

    protected static final int FABA = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.zhongliang1)
    TextView zhongliang1;
    @BindView(R.id.dong)
    EditText dong;
    @BindView(R.id.danyuan)
    EditText danyuan;
    @BindView(R.id.shoujia)
    EditText shoujia;
    @BindView(R.id.zhongliangwu)
    TextView zhongliangwu;
    @BindView(R.id.dianzhongliang)
    RelativeLayout dianzhongliang;
    @BindView(R.id.jiceng)
    EditText jiceng;
    @BindView(R.id.gong)
    EditText gong;
    @BindView(R.id.fangwuleixing)
    TextView fangwuleixing;
    @BindView(R.id.zhuangxiuleixing)
    TextView zhuangxiuleixing;
    @BindView(R.id.cheliang1)
    TextView cheliang1;
    @BindView(R.id.cheliang2)
    EditText cheliang2;
    @BindView(R.id.diancheliang)
    RelativeLayout diancheliang;
    @BindView(R.id.neitu)
    RecyclerView neitu;
    @BindView(R.id.shipin)
    TextView shipin;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.weituo)
    Button weituo;
    @BindView(R.id.lianxiren)
    EditText lianxiren;
    @BindView(R.id.dianhua)
    EditText dianhua;

    @Override
    protected int getResId() {
        return R.layout.activity_mai_fang2;
    }

    String mianji;
    String xiaoqu;
    String shi;
    String ceng;
    String wei;
    String shouji;
    String xiaji;
    String qu;
    String jiedao;
    String xiangxi;

    @Override
    protected void initData() {
        super.initData();

        setText(ttitle,"委托卖房");
        hide(subtitle);
        mianji = getIntent().getStringExtra("mianji");
        xiaoqu = getIntent().getStringExtra("xiaoqu");
        shi = getIntent().getStringExtra("shi");
        ceng = getIntent().getStringExtra("ceng");
        wei = getIntent().getStringExtra("wei");
        shouji = getIntent().getStringExtra("shouji");
        xiaji = getIntent().getStringExtra("xiaji");
        qu = getIntent().getStringExtra("qu");
        jiedao = getIntent().getStringExtra("jiedao");
        xiangxi = getIntent().getStringExtra("xiangxi");

        CommonApi.getInstance().select(3, MaiFang2Activity.this, SELECT,false);

//        intent.putExtra("xiaoqu",getString(xiaoqu));
//        intent.putExtra("shi",getString(shi));
//        intent.putExtra("ceng",getString(ceng));
//        intent.putExtra("wei",getString(wei));
//        intent.putExtra("shouji",getString(shouji));
//        intent.putExtra("xiaji",getIndex(xiaji, dizhi2.getText().toString().trim()));
//        intent.putExtra("qu",dizhi3.getText().toString().trim());
//        intent.putExtra("jiedao",dizhi4.getText().toString().trim());
    }


    @OnClick({R.id.back, R.id.fangwuleixing, R.id.zhuangxiuleixing, R.id.cheliang1, R.id.shipin, R.id.fabu, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.fangwuleixing:

                break;
            case R.id.zhuangxiuleixing:
                editLeiXingin((TextView) view, "请输入楼层单元", 5);
                break;
            case R.id.cheliang1:

                break;
            case R.id.shipin:

                break;
            case R.id.fabu:

                if (checkEmpty(dong, "请输入栋") && checkEmpty(danyuan, "请输入单元") &&
                        checkEmpty(shoujia, "请输入室") &&
                        checkEmpty(jiceng, "请输入楼层") &&
                        checkEmpty(gong, "请输入总楼层") &&
                        checkEmpty(lianxiren, "请输入联系人")
                       && CheckUtil.isMobile(MaiFang2Activity.this,getString(dianhua))) {
                    CommonApi.getInstance().wsell_fabu(getToken(), xiaoqu, mianji, shouji, shi,
                            ceng, wei, getString(dong)+"栋"+getString(danyuan)+"单元"+getString(shoujia)+"室", getString(jiceng), getString(gong), "sdf", "sdf",
                            "asdf", xiaji, qu, jiedao, getString(lianxiren),
                            getString(dianhua), "1", "2", "",
                            xiangxi, MaiFang2Activity.this
                            , FABA, true);
                }


                break;
            case R.id.weituo:
                break;
        }
    }

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case FABA:
                toast(base.getMessage());
                break;
        }
    }
}
