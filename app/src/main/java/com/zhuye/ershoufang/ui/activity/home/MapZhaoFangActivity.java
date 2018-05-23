package com.zhuye.ershoufang.ui.activity.home;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MapZhaoFangActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.xinfang)
    TextView xinfang;
    @BindView(R.id.ershoufang)
    TextView ershoufang;
    @BindView(R.id.zufang)
    TextView zufang;
    @BindView(R.id.quyu)
    TextView quyu;
    @BindView(R.id.jiage)
    TextView jiage;
    @BindView(R.id.huxing)
    TextView huxing;

    @Override
    protected int getResId() {
        return R.layout.activity_map_zhao_fang;
    }

    public void choose(TextView textView,TextView textView1,TextView textView2){
        int white = getResources().getColor(R.color.white);
        Drawable whitebg = getResources().getDrawable(R.drawable.shape_tuijian);
        int pramy = getResources().getColor(R.color.colorPrimary);
        Drawable pramybg = getResources().getDrawable(R.drawable.shape_tuijian2);
        textView.setTextColor(pramy);
        textView.setBackground(whitebg);

        textView1.setTextColor(white);
        textView1.setBackground(pramybg);
        textView2.setTextColor(white);
        textView2.setBackground(pramybg);
    }


    @OnClick({R.id.back, R.id.xinfang, R.id.ershoufang, R.id.zufang, R.id.quyu, R.id.jiage, R.id.huxing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinfang:
                choose(xinfang,ershoufang,zufang);
                break;
            case R.id.ershoufang:
                choose(ershoufang,xinfang,zufang);
                break;
            case R.id.zufang:
                choose(zufang,ershoufang,xinfang);
                break;

            case R.id.quyu:

                break;
            case R.id.jiage:

                break;
            case R.id.huxing:
                break;
        }
    }
}
