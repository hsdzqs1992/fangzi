package com.zhuye.ershoufang.ui.activity.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.LouPanBeans;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.weidtet.DataBean;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.MyTvSelectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddMianFeiKanActivity extends BaseActivity {

    private static final int GETDATA = 605;
    private static final int FABU = 606;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.title)
    MyInputView title;
    @BindView(R.id.youshi)
    MySelectTvView youshi;
    @BindView(R.id.suozailoupan)
    MyTvSelectView suozailoupan;
    @BindView(R.id.rexian)
    MyInputView rexian;
    @BindView(R.id.youhui)
    MyInputView youhui;
    @BindView(R.id.kaishishijian)
    MyInputView kaishishijian;
    @BindView(R.id.huodongguize)
    MyLinTv2View huodongguize;
    @BindView(R.id.mianze)
    MyLinTv2View mianze;
    @BindView(R.id.dizhi)
    MyLinTv2View dizhi;
    @BindView(R.id.fabu)
    Button fabu;
    @BindView(R.id.loupanleixing)
    MySelectTvView loupanleixing;
//    @BindView(R.id.my)
//    MyDongTaiView my;


    @Override
    protected int getResId() {
        return R.layout.activity_add_mian_fei_kan;
    }

    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "新增发布");
        hide(subtitle);
    }

    @OnClick({R.id.back, R.id.ttitle, R.id.fabu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ttitle:
                //my.addView(1);
                break;

            case R.id.fabu:
                if (title.getString() && youshi.hasPhoto() &&
                        suozailoupan.isChange() &&
                        rexian.getString() &&
                        youhui.getString() &&
                        kaishishijian.getString() &&
                        huodongguize.getString() &&
                        mianze.getString() &&
                        dizhi.getString()) {
                      CommonApi.getInstance().view_fabu(getToken(), suozailoupan.getId() + "", "",
                            title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(), kaishishijian.getContent(),
                            huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(), AddMianFeiKanActivity.this
                            , FABU);
                }
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().view_loupan(getToken(), AddMianFeiKanActivity.this, GETDATA);
    }

    CommonListBean<LouPanBeans> bean;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                bean = (CommonListBean<LouPanBeans>) base;
                if (bean.getData() == null || bean.getData().size() == 0) {
                    toast("请先添加楼盘");
                    return;
                }
                // TODO: 2018/5/14 0014  将title 转化为name
                List<DataBean> data = new ArrayList<>();
                for (int i = 0; i < bean.data.size(); i++) {
                    data.add(new DataBean(Integer.parseInt(bean.data.get(i).getId()), bean.data.get(i).getTitle()));
                }
                suozailoupan.setData(data);
                break;

            case FABU:
                toast(base.getMessage());

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
