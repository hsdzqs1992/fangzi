package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.WenDaAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.WenDaBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.me.TiWen2Activity;
import com.zhuye.ershoufang.utils.PageUtils;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.zhuye.ershoufang.utils.PageUtils.DELETE;

public class WenDaActivity extends BaseActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.tiwen)
    Button tiwen;


//    @BindView(R.id.back)
//    ImageView back;
//    @BindView(R.id.ttitle)
//    TextView ttitle;
//    @BindView(R.id.subtitle)
//    TextView subtitle;
//    //    @BindView(R.id.recycle)
////    RecyclerView recycle;
////    @BindView(R.id.refresh)
////    SmartRefreshLayout refresh;
//
//    @BindView(R.id.tablayout)
//    SmartTabLayout tablayout;
//    @BindView(R.id.viewpager)
//    ViewPager viewpager;
//    @BindView(R.id.refresh)
//    LinearLayout refresh;
//    @BindView(R.id.tiwen)
//    Button tiwen;

    @Override
    protected int getResId() {
        return R.layout.activity_wen_da;
    }


    @Override
    protected void onResume() {
        super.onResume();
        refresh.autoRefresh();
    }

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "我的问答");
        adapter2 = new WenDaAdapter(R.layout.wenda_item);
        recycle.setAdapter(adapter2);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
//        CommonApi.getInstance().my_question(SharedPreferencesUtil.getInstance().getString("token2"),1,
//                WenDaActivity.this,LIST);
        CommonApi.getInstance().my_question(SharedPreferencesUtil.getInstance().getString("token2"), PageUtils.FIRSTPAGE,
                WenDaActivity.this, PageUtils.FIRST);
        //设置自动刷新
        //  refresh.autoRefresh();
    }

    @OnClick({R.id.back, R.id.tiwen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tiwen:
                start(TiWen2Activity.class);
                break;
        }
    }


    CommonListBean<WenDaBean> bean;

    //
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        bean = PageUtils.totalData;
       PageUtils.handleData(WenDaActivity.this, requestcode, base, adapter2, refresh);


//        switch (requestcode){
////            case LIST:
////                bean = (WenDaListBean) base;
////                if(checkNull(bean.getData(),bean.getMessage())){
////                    adapter.addData(bean.getData());
////                }
////                break;
//            case DELETE:
//                toast(base.getMessage());
//                break;
//        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter2.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
//                PopWindowUtils.showWindow(WenDaActivity.this, view, "haoba", new PopWindowUtils.OnPclick() {
//                    @Override
//                    public void onclick(View view) {
//
//                    }
//
//                    @Override
//                    public void cancle(View view) {
//
//                    }
//                });

                // TODO: 2018/4/4 0004 长按事件

                CommonApi.getInstance().del_question(Integer.parseInt(bean.getData().get(position).getQuestion_id()), WenDaActivity.this, DELETE);
                return true;
            }
        });


        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                CommonApi.getInstance().my_question(SharedPreferencesUtil.getInstance().getString("token2"),PageUtils.FIRSTPAGE,
                        WenDaActivity.this, PageUtils.LOADMORE);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                CommonApi.getInstance().my_question(SharedPreferencesUtil.getInstance().getString("token2"),PageUtils.requestPage,
                        WenDaActivity.this, PageUtils.REFRESH);
            }
        });


        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(WenDaActivity.this,WenDaDetailActivity.class);
                intent.putExtra("id",bean.getData().get(position).getQuestion_id());
                startActivity(intent);
            }
        });
    }

}
