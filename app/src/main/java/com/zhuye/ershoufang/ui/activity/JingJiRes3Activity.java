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
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class JingJiRes3Activity extends BaseActivity {


    private static final int SUBMIT = 100;
    private static final int UPIMG = 101;
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
        return R.layout.activity_jing_ji_res3;
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
                //上传图片
                if (photos == null) {
                    toast("请选择身份证照片");
                    return;
                }
                GetData.upimg("", FilesUtil.getSmallBitmap(JingJiRes3Activity.this, photos.get(0)), JingJiRes3Activity.this, UPIMG);

//               OkGo.<String>post(NetWorkUrl.BASE+"index.php/App/index/upimg")
//                       .params("file",FilesUtil.getSmallBitmap(JingJiRes3Activity.this,photos.get(0)))
//                       .execute(new StringCallback() {
//                           @Override
//                           public void onSuccess(Response<String> response) {
//                               Log.i("asdf",name +gongsi +work);
//                           }
//
//                           @Override
//                           public void onError(Response<String> response) {
//                               super.onError(response);
//                               Log.i("asdf",name +gongsi +work);
//                           }
//                       });
                break;
        }
    }

    String name;
    String gongsi;
    String work;
    String city_id;
    String scope_work;
    String iszhu;

    @Override
    protected void initData() {
        super.initData();
        name = (String) getTData(0, 0);
        gongsi = (String) getTData(0, 1);
        city_id = (String) getTData(0, 2);
        scope_work = (String) getTData(0, 3);
        iszhu = (String) getTData(0, 4);
        hide(subtitle);
        setText(ttitle,"经纪人注册");
      //  Log.i("asdf", name + gongsi + work);
    }

    @Override
    protected void initView() {
        super.initView();
    }

    private void selectPhoto() {
        PhotoPicker.builder()
                .setPhotoCount(1)//可选择图片数量
                .setShowCamera(true)//是否显示拍照按钮
                .setShowGif(true)//是否显示动态图
                .setPreviewEnabled(true)//是否可以预览
                .start(JingJiRes3Activity.this, PhotoPicker.REQUEST_CODE);
    }

    ArrayList<String> photos;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                shenfenzheng.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(JingJiRes3Activity.this, photos.get(0))));
            }
        }
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case SUBMIT:
                toast(o.getMessage());
                start(LoginActivity.class, true);
                break;
            case UPIMG:
                UploadImgBean uploadImgBean = (UploadImgBean) o;
                GetData.user_data(SharedPreferencesUtil.getInstance().getString("token"),
                        getString(loginname), getString(card), uploadImgBean.getData().getFace(), iszhu.equals("1") ? 0 : 1,
                        scope_work, "",
                        city_id, gongsi
                        , JingJiRes3Activity.this, SUBMIT);
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
