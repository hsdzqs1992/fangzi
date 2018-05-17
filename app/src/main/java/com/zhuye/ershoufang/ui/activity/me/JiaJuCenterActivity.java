package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.PersonInfoBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.MyLinTv2View;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class JiaJuCenterActivity extends BaseActivity {


    private static final int GETDATA = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.touxing)
    RoundedCornerImageView touxing;
    @BindView(R.id.xingxiang)
    MyInputView xingxiang;
    @BindView(R.id.mingcheng)
    MyInputView mingcheng;
    @BindView(R.id.shangjiajianjie)
    MyLinTv2View shangjiajianjie;
    @BindView(R.id.zhanghao)
    MyInputView zhanghao;
    @BindView(R.id.shenfenrenzh)
    MyInputView shenfenrenzh;
    @BindView(R.id.yingyezhizhao)
    MyInputView yingyezhizhao;
    @BindView(R.id.edit)
    Button edit;

    @Override
    protected int getResId() {
        return R.layout.activity_jia_ju_center;
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().message(getToken(),this,GETDATA);
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"个人信息");
        zhanghao.nocanChange();
    }

    @OnClick({R.id.back, R.id.edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.edit:

                break;
        }
    }

    CommonObjectBean<PersonInfoBean> bean;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonObjectBean<PersonInfoBean>) base;
                Glide.with(JiaJuCenterActivity.this).
                        load(NetWorkUrl.IMAGEURL+bean.getData().getShop_face()).
                        into(touxing);
                mingcheng.setContent(bean.getData().getShop());
                shangjiajianjie.setContext(bean.getData().getShop_detail());
                zhanghao.setContent(bean.getData().getAccount());
                break;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        shenfenrenzh.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                toast("sdfasdf");
                Intent  intent = new Intent(JiaJuCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean.getData().getCard_img());
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
        yingyezhizhao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(JiaJuCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean.getData().getLicense());
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });

        xingxiang.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(JiaJuCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path","");
                intent.putExtra("type",3);
                startActivityForResult(intent,100);
            }
        });
    }

    String xingx ="";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                xingx = data.getStringExtra("file");
                break;
        }
    }
}
