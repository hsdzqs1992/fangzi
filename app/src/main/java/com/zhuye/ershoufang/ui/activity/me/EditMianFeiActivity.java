package com.zhuye.ershoufang.ui.activity.me;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.MianBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.MyTvSelectView;

import butterknife.BindView;
import butterknife.OnClick;

public class EditMianFeiActivity extends BaseActivity {


    private static final int GETDATA = 888;
    private static final int EDIT = 889;
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
    @BindView(R.id.loupanleixing)
    MySelectTvView loupanleixing;
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

    @Override
    protected int getResId() {
        return R.layout.activity_edit_mian_fei;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"免费看房编辑");
    }

    String id;

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().hview_view(getToken(), id, this, GETDATA);
    }

    CommonObjectBean<MianBean> bean;

    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                bean = (CommonObjectBean<MianBean>) base;
                // TODO: 2018/5/16 0016 设置数据
                title.setContent(bean.getData().getTitle());
                rexian.setContent(bean.getData().getMobile());
                youhui.setContent(bean.getData().getYouhui());
                huodongguize.setContext(bean.getData().getGuize());
                mianze.setContext(bean.getData().getSm());
                dizhi.setContext(bean.getData().getAddr());

                break;
            case EDIT:
                toast(base.getMessage());
                finish();
                break;
        }
    }


    @OnClick({R.id.back, R.id.fabu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
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
                    CommonApi.getInstance().view_sub(getToken(), suozailoupan.getId() + "", "",
                            title.getContent(), youshi.getPhoto(), loupanleixing.getPhoto(), rexian.getContent(), kaishishijian.getContent(),
                            huodongguize.getContent(), mianze.getContent(), dizhi.getContent(), youhui.getContent(),
                            id,
                            EditMianFeiActivity.this
                            , EDIT);
                }
                break;
        }
    }
}
