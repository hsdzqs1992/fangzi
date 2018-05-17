package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MeChongZhiAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.ZhiDingBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.weidtet.MyGridLayoutManager;

import butterknife.BindView;
import butterknife.OnClick;

public class ChongZhiActivity extends BaseActivity {


    private static final int GETDATA = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.alipay)
    ImageView alipay;
    @BindView(R.id.alipay2)
    RelativeLayout alipay2;
    @BindView(R.id.weixin)
    ImageView weixin;
    @BindView(R.id.wexinpay2)
    RelativeLayout wexinpay;
    @BindView(R.id.pay)
    Button pay;
    @BindView(R.id.choose1)
    ImageView choose1;
    @BindView(R.id.choose2)
    ImageView choose2;

    @Override
    protected int getResId() {
        return R.layout.activity_chong_zhi;
    }


    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("充值");
        subtitle.setText("充值记录");
        adapter = new MeChongZhiAdapter(R.layout.me_chongzhi_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new MyGridLayoutManager(this,3));
    }

    @OnClick({R.id.back, R.id.subtitle, R.id.alipay2, R.id.wexinpay2, R.id.pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                Intent intent = new Intent(ChongZhiActivity.this, ChongZhiJilvActivity.class);
                startActivity(intent);
                break;
            case R.id.alipay2:
                hide(choose2);
                show(choose1);
                break;
            case R.id.wexinpay2:
                show(choose2);
                hide(choose1);
                break;
            case R.id.pay:

                break;
        }
    }

    CommonListBean<ZhiDingBean> bean ;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case GETDATA:
                bean = (CommonListBean<ZhiDingBean>) base;
                bean.getData().get(0).setChoose(true);
                adapter.addData(bean.getData());
                break;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().juan(this,GETDATA);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (ZhiDingBean bean1: bean.getData()){
                    bean1.setChoose(false);
                }
                bean.getData().get(position).setChoose(true);
                adapter.replaceData(bean.getData());
            }
        });
    }
}
