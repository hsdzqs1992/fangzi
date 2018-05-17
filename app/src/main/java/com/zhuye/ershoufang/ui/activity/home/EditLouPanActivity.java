package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.LouBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyRecycleView;
import com.zhuye.ershoufang.weidtet.MySelectPhotoView;
import com.zhuye.ershoufang.weidtet.MySelectTvView;
import com.zhuye.ershoufang.weidtet.MyTvSelectView;

import butterknife.BindView;
import butterknife.OnClick;

public class EditLouPanActivity extends BaseActivity {

    private static final int GETDATA = 888;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.title)
    MyInputView title;
    @BindView(R.id.mianjia)
    MyInputView mianjia;
    @BindView(R.id.fangyuanleixing)
    MyTvSelectView fangyuanleixing;
    @BindView(R.id.fangyuanzhong)
    MyTvSelectView fangyuanzhong;
    @BindView(R.id.peizhiba)
    MySelectTvView peizhiba;
    @BindView(R.id.modi1)
    TextView modi1;
    @BindView(R.id.youshi)
    RelativeLayout youshi;
    @BindView(R.id.danjia)
    MyInputView danjia;
    @BindView(R.id.youhui)
    MyInputView youhui;
    @BindView(R.id.youhishijian)
    MyInputView youhishijian;
    @BindView(R.id.youhiendtime)
    MyInputView youhiendtime;
    @BindView(R.id.kaipanshijian)
    MyInputView kaipanshijian;
    @BindView(R.id.jiaofangshijian)
    MyInputView jiaofangshijian;
    @BindView(R.id.quyu)
    MyInputView quyu;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.dizhi2)
    TextView dizhi2;
    @BindView(R.id.dizhi3)
    TextView dizhi3;
    @BindView(R.id.dizhi4)
    TextView dizhi4;
    @BindView(R.id.xianxidizhi)
    MyInputView xianxidizhi;
    @BindView(R.id.dianhua)
    MyInputView dianhua;
    @BindView(R.id.huxingrv)
    MyRecycleView huxingrv;
    @BindView(R.id.addhuxing)
    Button addhuxing;
    @BindView(R.id.xiaoguo)
    MySelectPhotoView xiaoguo;
    @BindView(R.id.shijing)
    MySelectPhotoView shijing;
    @BindView(R.id.peitao)
    MySelectPhotoView peitao;
    @BindView(R.id.guihuatu)
    MySelectPhotoView guihuatu;
    @BindView(R.id.jiaotong)
    MySelectPhotoView jiaotong;
    @BindView(R.id.weituo)
    Button weituo;

    @Override
    protected int getResId() {
        return R.layout.activity_edit_lou_pan;
    }

    String id;


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"楼盘编辑");
    }

    @Override
    protected void initData() {
        super.initData();
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().newhouse_edit(getToken(), id, this, GETDATA);
    }

    CommonObjectBean<LouBean> bean ;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case GETDATA:
                bean = (CommonObjectBean<LouBean>) base;
                title.setContent(bean.getData().getTitle());
                mianjia.setContent(bean.getData().getMianji());
                danjia.setContent(bean.getData().getPrice());

                youhui.setContent(bean.getData().getYouhui());
                youhishijian.setContent(bean.getData().getYouhui_starttime());
                youhiendtime.setContent(bean.getData().getYouhui_endtime());

                kaipanshijian.setContent(bean.getData().getKdate());
                jiaofangshijian.setContent(bean.getData().getJdate());

                dianhua.setContent(bean.getData().getMobile());
                //
                break;
        }
    }


    @OnClick({R.id.back, R.id.weituo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.weituo:

                break;
        }
    }
}
