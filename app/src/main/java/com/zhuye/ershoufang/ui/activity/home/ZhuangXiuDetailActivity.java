package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.ZhuangxiuJiaJuBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.data.NetWorkUrl;

import butterknife.BindView;
import butterknife.OnClick;

public class ZhuangXiuDetailActivity extends BaseActivity {

    private static final int GETDATA = 888;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.shoucang)
    TextView shoucang;
    @BindView(R.id.goutomg)
    TextView goutomg;

    @Override
    protected int getResId() {
        return R.layout.activity_zhuang_xiu_detail;
    }

    String id ;
    @Override
    protected void initView() {
        super.initView();
        id = getIntent().getStringExtra("id");
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().detail(Integer.parseInt(id),this,GETDATA);
    }

    CommonObjectBean<ZhuangxiuJiaJuBean> bean ;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonObjectBean<ZhuangxiuJiaJuBean>) base;
                //ImageView imageView = helper.getView(R.id.image);
                Glide.with(ZhuangXiuDetailActivity.this).load(NetWorkUrl.IMAGEURL+bean.getData().getShop_face()).into(image);
                  // helper.setText(R.id.title,item.getShop_detail()).setText(R.id.name,item.getShop());
                break;
        }
    }

    @OnClick({R.id.shoucang, R.id.goutomg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shoucang:

                break;
            case R.id.goutomg:

                break;
        }
    }
}
