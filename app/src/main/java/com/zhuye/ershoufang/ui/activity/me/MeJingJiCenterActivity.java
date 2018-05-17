package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.JingJiRSettingBean;
import com.zhuye.ershoufang.bean.PersonBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;
import com.zhuye.ershoufang.ui.activity.ChangeMobile1Activity;
import com.zhuye.ershoufang.utils.FilesUtil;
import com.zhuye.ershoufang.weidtet.MyInputView;
import com.zhuye.ershoufang.weidtet.RoundedCornerImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;

public class MeJingJiCenterActivity extends BaseActivity {

    private static final int GETDATA = 999;
    private static final int SHENFEN = 1000;
    private static final int BIANJI = 1001;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.touxing)
    RoundedCornerImageView touxing;
    @BindView(R.id.xingming)
    MyInputView xingming;
    @BindView(R.id.zhanghao)
    MyInputView zhanghao;
    @BindView(R.id.shenfenrenzh)
    MyInputView shenfenrenzh;
    @BindView(R.id.edit)
    Button edit;

    @Override
    protected int getResId() {
        return R.layout.activity_me_jing_ji_center;
    }


    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"个人中心");

        zhanghao.setRightArrow();

        xingming.nocanChange();
        zhanghao.nocanChange();
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().jinjirense(getToken(),this,GETDATA);
        CommonApi.getInstance().renzheng(getToken(),this,SHENFEN,false);
    }

    @OnClick({R.id.back, R.id.edit,R.id.touxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.edit:
                if((photos!=null ||photos.size()==0)&&xingming.getTx2().equals(bean.getData().getShop())){
                    return;
                }else {
                    if(TextUtils.isEmpty(xingming.getTx2())){
                        toast("请输入姓名");
                        return;
                    }else {
                        CommonApi.getInstance().sub_set(getToken(),photos!=null ||photos.size()==0?bean.getData().getShop_face():photos.get(0)
                        ,xingming.getTx2(),MeJingJiCenterActivity.this,BIANJI);
                    }
                }
                break;

            case R.id.touxing:
                selectPhoto();
                break;
        }
    }

    List<String> photos;

    private void selectPhoto() {
        PhotoPicker.builder()
                .setPhotoCount(1)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start(this, PhotoPicker.REQUEST_CODE);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
                //
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        touxing.setImageURI(Uri.fromFile(FilesUtil.getSmallBitmap(MeJingJiCenterActivity.this, photos.get(0))));
                    }
                });
                //photo.setVisibility(View.GONE);
            }
        }
    }

    CommonObjectBean<JingJiRSettingBean> bean;
    CommonObjectBean<PersonBean> bean1;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonObjectBean<JingJiRSettingBean>) base;
                Glide.with(MeJingJiCenterActivity.this).
                        load(NetWorkUrl.IMAGEURL+bean.getData().getShop_face()).
                        into(touxing);
                xingming.setTx2(bean.getData().getShop());
                zhanghao.setTx2(bean.getData().getMobile());
                break;
            case SHENFEN:
                bean1 = (CommonObjectBean<PersonBean>) base;
                break;
            case BIANJI:
                toast(base.getMessage());
                break;
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        shenfenrenzh.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeJingJiCenterActivity.this,MeLookShenFenActivity.class);
                intent.putExtra("path",bean1.getData().getCard_img());
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });

        zhanghao.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                toast("asdfasdf");
                start(ChangeMobile1Activity.class);
            }
        });
        xingming.itemClick(new MyInputView.OnClick() {
            @Override
            public void onClick(View view) {
                xingming.setTv2InClick();
            }
        });
    }
}
