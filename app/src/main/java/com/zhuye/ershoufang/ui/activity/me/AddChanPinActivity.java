package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.ChanPinBean;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class AddChanPinActivity extends BaseActivity {


    private static final int ADDD = 1088;
    private static final int UPIMG = 1089;
    private static final int EDIT = 1090;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.mingcheng1)
    TextView mingcheng1;
    @BindView(R.id.mingcheng)
    EditText mingcheng;
    @BindView(R.id.dianhuowu)
    LinearLayout dianhuowu;
    @BindView(R.id.jianjie)
    EditText jianjie;
    @BindView(R.id.tijiao)
    Button tijiao;
    @BindView(R.id.iv2)
    ImageView iv2;

    @Override
    protected int getResId() {
        return R.layout.activity_add_chan_pin;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);

    }

    @OnClick({R.id.back, R.id.tijiao, R.id.photo,R.id.iv2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv2:
            case R.id.photo:
                selectPhoto();
                break;
            case R.id.back:
                finish();
                break;
            case R.id.tijiao:
                switch (type){
                    case 1:
                        edit();
                        break;
                    case 2:
                        tianjia();
                        break;
                }
                break;
        }
    }

    private void edit() {
        if (checkEmpty(mingcheng, "请输入产品名称") && checkEmpty(jianjie, "请输入产品简介")) {
            if (photos != null && photos.size() == 1) {
                upImg();
            }else {
                CommonApi.getInstance().jiajuedit(getToken(),phot,getString(mingcheng),getString(jianjie)
                        ,id,AddChanPinActivity.this,ADDD);
            }
        }
    }

    private void tianjia() {
        if (photos == null || photos.size() < 1) {
            toast("请选择图片");
            return;
        }
        if (checkEmpty(mingcheng, "请输入产品名称") && checkEmpty(jianjie, "请输入产品简介")) {
            upImg();
        }
    }

    private void upImg() {
        GetData.upimg(getToken(), FilesUtil.getSmallBitmap(
                AddChanPinActivity.this, photos.get(0)),
                AddChanPinActivity.this, UPIMG);
    }

    private void selectPhoto() {
        PhotoPicker.builder()
                .setPhotoCount(1)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start(this, PhotoPicker.REQUEST_CODE);
    }

    ArrayList<String> photos;

    // TODO: 2018/5/16 0016 编辑的时候不显示
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                iv2.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(AddChanPinActivity.this, photos.get(0))));
                photo.setVisibility(View.GONE);
            }
        }
    }



    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode) {
            case ADDD:
                toast(base.getMessage());
                finish();
                break;

            case UPIMG:
                UploadImgBean bean = (UploadImgBean) base;
                switch (type){
                    case 1:
                        CommonApi.getInstance().jiajuedit(getToken(),bean.getData().getFace(),getString(mingcheng),getString(jianjie)
                        ,id,AddChanPinActivity.this,ADDD);
                        break;
                    case 2:
                        CommonApi.getInstance().jiajufabu(getToken(), bean.getData().getFace(), getString(mingcheng)
                                , getString(jianjie), AddChanPinActivity.this, ADDD);
                        break;
                }

                break;
            case EDIT:
                CommonObjectBean<ChanPinBean> bean1 = (CommonObjectBean<ChanPinBean>) base;
                Glide.with(AddChanPinActivity.this).load(NetWorkUrl.IMAGEURL+bean1.getData().getPhoto()).into(iv2);
                photo.setVisibility(View.GONE);
                mingcheng.setText(bean1.getData().getTitle());
                jianjie.setText(bean1.getData().getIntro());
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    int type;
    String id;
    String phot;
    @Override
    protected void initData() {
        super.initData();
         type =  getIntent().getIntExtra("type",0);
         switch (type){
             case 1:
                 //编辑
                  id= getIntent().getStringExtra("id");
                  phot= getIntent().getStringExtra("photo");
                 CommonApi.getInstance().jiajuview(Integer.parseInt(id),AddChanPinActivity.this,EDIT);
                 setText(ttitle, "编辑");
                 break;
             case 2:
                 //添加
                 setText(ttitle, "添加");
                 break;
         }
    }
}
