package com.zhuye.ershoufang.ui.activity.home;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.HomefenleiAdapter;
import com.zhuye.ershoufang.adapter.home.XieZiLouAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.FenLeiBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class XieZiLouActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.rvv)
    RecyclerView rvv;
    @BindView(R.id.tablayout)
    SmartTabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getResId() {
        return R.layout.activity_xie_zi_lou;
    }


    @Override
    protected void initView() {
        super.initView();
        setText(ttitle, "商铺写字楼");
        hide(subtitle);

        adapter = new HomefenleiAdapter(R.layout.me_rv);
        rvv.setAdapter(adapter);
        rvv.setLayoutManager(new GridLayoutManager(this,3));
    }

    protected int[] imgs = {R.drawable.xinpan,
            R.drawable.chuzu, R.drawable.chushou, R.drawable
            .xiezilou, R.drawable.xiezilouchuzu, R.drawable.xiezilouchushou,};

    @Override
    protected void initData() {
        super.initData();
        titles = getResources().getStringArray(R.array.home_xiezilou);
        List<FenLeiBean.FenBean> data = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            FenLeiBean.FenBean bean = new FenLeiBean.FenBean();
            bean.stringRes = titles[i];
            bean.imgRes = imgs[i];
            data.add(bean);
        }
        adapter.addData(data);

        XieZiLouAdapter adapter1 = new XieZiLouAdapter(getSupportFragmentManager(),this);
        viewpager.setAdapter(adapter1);
        tablayout.setViewPager(viewpager);

    }


    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        Intent intent  = new Intent(XieZiLouActivity.this,XinPanActivity.class);
                        intent.putExtra("cate_id",2+"");
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1  = new Intent(XieZiLouActivity.this,ChuShouActivity.class);
                        intent1.putExtra("cate_id",13+"");
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2  = new Intent(XieZiLouActivity.this,ChuShouActivity.class);
                        intent2.putExtra("cate_id",7+"");
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3  = new Intent(XieZiLouActivity.this,XinPanActivity.class);
                        intent3.putExtra("cate_id",3+"");
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4  = new Intent(XieZiLouActivity.this,ChuShouActivity.class);
                        intent4.putExtra("cate_id",12+"");
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5  = new Intent(XieZiLouActivity.this,ChuShouActivity.class);
                        intent5.putExtra("cate_id",6+"");
                        startActivity(intent5);
                        break;
                }
            }
        });
    }
}
