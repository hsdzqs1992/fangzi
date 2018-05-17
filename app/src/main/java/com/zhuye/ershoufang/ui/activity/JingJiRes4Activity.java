package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.data.GetData;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class JingJiRes4Activity extends BaseActivity {

    private static final int UPIMG = 101;
    private static final int SUBMIT = 102;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.types)
    TextView types;
    @BindView(R.id.shenfenzheng)
    ImageView shenfenzheng;
    @BindView(R.id.next)
    Button next;

    @Override
    protected int getResId() {
        return R.layout.activity_jing_ji_res4;
    }

    private void selectPhoto() {
        PhotoPicker.builder()
                .setPhotoCount(1)//可选择图片数量
                .setShowCamera(true)//是否显示拍照按钮
                .setShowGif(true)//是否显示动态图
                .setPreviewEnabled(true)//是否可以预览
                .start(JingJiRes4Activity.this, PhotoPicker.REQUEST_CODE);
    }


    ArrayList<String> photos;
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos  = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                shenfenzheng.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(JingJiRes4Activity.this,photos.get(0))));
            }
        }
    }




    String name;
    String card;
    String cardimg;


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        type = (Integer) getTData(1,0);
        switch (type){
            case 2:
                setText(ttitle,"房产商注册");
                setText(types,"房产商开发企业资质证书");
                break;
            case 3:
                setText(ttitle,"家居商注册");
                setText(types,"营业执照");
                break;
            case 4:
                setText(ttitle,"装修商注册");
                setText(types,"营业执照");
                break;
        }
//        setText(ttitle);
       name = (String) getTData(0,2);
        cardimg = (String) getTData(0,1);
       card = (String) getTData(0,3);
    }

    @OnClick({R.id.back, R.id.shenfenzheng, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.shenfenzheng:
                selectPhoto();
                break;
            case R.id.next:
                if(checkNull(photos,"请上传图片")){
                    //提交数据
                    GetData.upimg("",FilesUtil.getSmallBitmap(JingJiRes4Activity.this,photos.get(0)),JingJiRes4Activity.this,UPIMG);
                }
                break;
        }
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case SUBMIT:
                toast(o.getMessage());
                start(LoginActivity.class,true);
                break;
            case UPIMG:
                GetData.user_data(SharedPreferencesUtil.getInstance().getString("token"),name,card,cardimg,1,"","","",""
                        ,JingJiRes4Activity.this,SUBMIT);
                break;
        }
    }
}
