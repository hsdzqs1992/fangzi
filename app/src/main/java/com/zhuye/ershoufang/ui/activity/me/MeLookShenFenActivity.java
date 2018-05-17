package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.utils.FilesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class MeLookShenFenActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.iamgess)
    ImageView iamgess;

    @Override
    protected int getResId() {
        return R.layout.activity_me_look_shen_fen;
    }


    int ty;
    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        ty = getIntent().getIntExtra("type", 0);
        String path = getIntent().getStringExtra("path");
        Glide.with(this).load(NetWorkUrl.IMAGEURL + path).into(iamgess);
        switch (ty) {
            case 1:
                setText(ttitle, "身份认证");
                break;
            case 2:
                setText(ttitle, "营业执照");
                break;

            case 3:
                type.setText("请选择店铺形象");
                setText(ttitle, "店铺形象");
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.iamgess})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finishs();
                break;
            case R.id.iamgess:
                selectPhoto();
                break;
        }
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
                //
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iamgess.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(MeLookShenFenActivity.this, photos.get(0))));
                    }
                });
                //photo.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onBackPressed() {
        finishs();
    }

    private void finishs() {
        switch (ty){
            case 3:
                if(photos==null||photos.size()<0){
                    toast("请选择店铺形象");
                    return;
                }else {
                    Intent i = new Intent();
                    i.putExtra("file",photos.get(0));
                    setResult(100,i);
                    finish();
                }
                break;
            default:
                finish();
        }
    }
}
