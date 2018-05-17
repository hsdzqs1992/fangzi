package com.zhuye.ershoufang.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.JingJiRenBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.weidtet.DataBean;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.MyRecycleView2;
import com.zhuye.ershoufang.weidtet.MyTvSelectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingJiRenZiLiaoActivity extends SelectCityActivity {

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
    MyRecycleView2 congye;
    @BindView(R.id.suoshu)
    MyLinTv2View suoshu;
    @BindView(R.id.zhuyingyewu)
    MyTvSelectView zhuyingyewu;
    @BindView(R.id.fuwunianxian)
    MyTvSelectView fuwunianxian;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.add6)
    Button add;

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
                zhuying.setTx2(bean.getData().getMain_business().equals("0") ? "住宅" : "商业地产");
                fuwuyear.setContent(bean.getData().getYear());
                //
                // gongzuo.setContext(bean.getData());
                zhuyongxiaoqu.setContext(bean.getData().getXiaoqu());
                fangyuantedian.setContext(bean.getData().getTese());
                yongjinbi.setContent(bean.getData().getYjbi());

                break;

            case TIJIAO:
                toast(base.getMessage());
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
//        zhuyingyewu.setData("0", "住宅", "1", "商业地产");
//        fuwunianxian.setData("0.5", "半年",
//                "1", "一年", "2", "两年",
//                "3", "三年", "4", "四年",
//                "5", "五年", "6", "六年",
//                "7", "千年", "8", "八年");
        List<DataBean> dataBeans = new ArrayList<>();
        DataBean dataBean = new DataBean(1, "住宅");
        DataBean dataBean2 = new DataBean(2, "商业地产");
        dataBeans.add(dataBean);
        dataBeans.add(dataBean2);
        zhuyingyewu.setData(dataBeans);


        // 房源种类 1住宅 2商铺 3写字楼 4工业厂房
        List<DataBean> dataBeans1 = new ArrayList<>();
        DataBean dataBean1 = new DataBean(1, "半年");
        DataBean dataBean22 = new DataBean(2, "一年");
        DataBean dataBean33 = new DataBean(3, "两年");
        DataBean dataBean44 = new DataBean(4, "三年");
        DataBean dataBean45 = new DataBean(5, "四年");
        DataBean dataBean46 = new DataBean(6, "五年");
        DataBean dataBean47 = new DataBean(7, "六年");
        DataBean dataBean48 = new DataBean(8, "七年");
        DataBean dataBean49 = new DataBean(9, "八年");

        dataBeans1.add(dataBean1);
        dataBeans1.add(dataBean22);
        dataBeans1.add(dataBean33);
        dataBeans1.add(dataBean44);
        dataBeans1.add(dataBean45);
        dataBeans1.add(dataBean46);
        dataBeans1.add(dataBean47);
        dataBeans1.add(dataBean48);
        dataBeans1.add(dataBean49);
        fuwunianxian.setData(dataBeans1);
    }

    @OnClick({R.id.add6,R.id.dizhi, R.id.dizhi2, R.id.dizhi3, R.id.dizhi4, R.id.back, R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add6:
                congye.add();
                break;
            case R.id.dizhi4:
                editLeiXing((TextView) view, "请输入朝向", 9);
                break;
            case R.id.dizhi:
                editLeiXing((TextView) view, "请输入朝向", 6);
                break;
            case R.id.dizhi2:
                editLeiXing((TextView) view, "请输入朝向", 7);
                break;
            case R.id.dizhi3:
                editLeiXing((TextView) view, "请输入朝向", 8);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                if (maifangxuanyan.getString() && ferenjianjie.getString() &&
                        suoshu.getString() &&
                        mendian.getString() &&
                        zhuyongxiaoqu.getString() &&
                        fangyuantedian.getString()) {
                    CommonApi.getInstance().sub_data(
                            getToken(),
                            getIndex(xiaji, dizhi2.getText().toString().trim()),
                            getIndex(qu, dizhi3.getText().toString().trim()),
                            zhuyingyewu.getId()+"",
                            maifangxuanyan.getContent(),
                            ferenjianjie.getContent(),
                            fuwunianxian.getId()+ ""
                            , suoshu.getContent(),
                            zhuyongxiaoqu.getContent()
                            , fangyuantedian.getContent(),
                            "", "",
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
