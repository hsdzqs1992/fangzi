package com.zhuye.ershoufang.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.JingJiRenBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingJiRenZiLiaoActivity extends BaseActivity {

    private static final int GETDATA = 1000;
    private static final int TIJIAO = 1001;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.maifangxuanyan)
    MyLinTv2View maifangxuanyan;
    @BindView(R.id.ferenjianjie)
    MyLinTv2View ferenjianjie;
    @BindView(R.id.mendian)
    MyLinTv2View mendian;
    @BindView(R.id.zhuying)
    MyInputView zhuying;
    @BindView(R.id.fuwuyear)
    MyInputView fuwuyear;
    @BindView(R.id.gongzuo)
    MyLinTv2View gongzuo;
    @BindView(R.id.zhuyongxiaoqu)
    MyLinTv2View zhuyongxiaoqu;
    @BindView(R.id.fangyuantedian)
    MyLinTv2View fangyuantedian;
    @BindView(R.id.shujufenxi)
    MyInputView shujufenxi;
    @BindView(R.id.yongjinbi)
    MyInputView yongjinbi;
    @BindView(R.id.congye)
    RecyclerView congye;
    @BindView(R.id.suoshu)
    MyLinTv2View suoshu;

    @Override
    protected int getResId() {
        return R.layout.activity_jing_ji_ren_zi_liao;
    }

    CommonObjectBean<JingJiRenBean> bean;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                bean = (CommonObjectBean<JingJiRenBean>) base;
                maifangxuanyan.setContext(bean.getData().getDeclaration());
                ferenjianjie.setContext(bean.getData().getIntro());
                suoshu.setContext(bean.getData().getShop());
                mendian.setContext(bean.getData().getCompany());
                zhuying.setTx2(bean.getData().getMain_business().equals("0")?"住宅":"商业地产");
                fuwuyear.setContent(bean.getData().getYear());
               //
                // gongzuo.setContext(bean.getData());
                zhuyongxiaoqu.setContext(bean.getData().getXiaoqu());
                fangyuantedian.setContext(bean.getData().getTese());
                yongjinbi.setContent(bean.getData().getYjbi());

                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "经纪人资料");
        setText(subtitle, "编辑");
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().data(getToken(), this, GETDATA);
    }

    @OnClick({R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                if(maifangxuanyan.getString()&&ferenjianjie.getString()&&
                        suoshu.getString()&&
                        mendian.getString()&&
                        zhuyongxiaoqu.getString()&&
                        fangyuantedian.getString()){
                    CommonApi.getInstance().sub_data(
                             getToken(),
                            "","",
                            "",
                             maifangxuanyan.getContent(),
                            ferenjianjie.getContent(),
                            ""
                            ,suoshu.getContent(),
                            zhuyongxiaoqu.getContent()
                            ,fangyuantedian.getContent(),
                            "","",
                            JingJiRenZiLiaoActivity.this,
                            TIJIAO,
                            true);
                }
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
