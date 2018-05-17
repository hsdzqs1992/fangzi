package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.UploadImgBean;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.FilesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class OthersRes3Activity extends BaseActivity {

    private static final int UPIMG = 100;
    @BindView(R.id.loginname)
    EditText loginname;
    @BindView(R.id.card)
    EditText card;
    @BindView(R.id.shenfenzheng)
    ImageView shenfenzheng;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;

    @Override
    protected int getResId() {
        return R.layout.activity_others_res3;
    }


    @OnClick({R.id.back,R.id.shenfenzheng, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.shenfenzheng:
                selectPhoto();
                break;
            case R.id.next:
                if (checkEmpty(loginname, "请输入真实姓名")
                        && checkEmpty(card, "请输入身份证号码")
                        && checkNull(photos, "请选择身份证照片")) {
                    GetData.upimg("", FilesUtil.getSmallBitmap(OthersRes3Activity.this, photos.get(0)), OthersRes3Activity.this, UPIMG);
                }
//                if(photos==null){
//                    toast("请选择身份证照片");
//                    return;
//                }

                break;
        }
    }

    private static final int SUBMIT = 101;

    private void selectPhoto() {
        PhotoPicker.builder()
                .setPhotoCount(1)//可选择图片数量
                .setShowCamera(true)//是否显示拍照按钮
                .setShowGif(true)//是否显示动态图
                .setPreviewEnabled(true)//是否可以预览
                .start(OthersRes3Activity.this, PhotoPicker.REQUEST_CODE);
    }

    ArrayList<String> photos;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                shenfenzheng.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(OthersRes3Activity.this, photos.get(0))));
            }
        }
    }


    String typess;

    @Override
    protected void initData() {
        super.initData();
        typess = (String) getTData(0, 0);
        hide(subtitle);
        if (typess.equals("2")) {
            setText(ttitle,"房产商注册");
        } else if (typess.equals("3")) {
            setText(ttitle,"家具商注册");
        } else if (typess.equals("4")) {
            setText(ttitle,"装修公司注册");
        }
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case SUBMIT:
                toast(o.getMessage());
                break;
            case UPIMG:
//                GetData.user_data("",getString(loginname),getString(card),"",1,"",""
//                        ,OthersRes3Activity.this,SUBMIT);
                UploadImgBean bean = (UploadImgBean) o;
                start(JingJiRes4Activity.class, typess, bean.getData().getFace(), getString(loginname), getString(card));
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
