package com.zhuye.ershoufang.ui.activity.me;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MeWeiTuoAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonListBean;
import com.zhuye.ershoufang.bean.QiTeBean;
import com.zhuye.ershoufang.data.CommonApi;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WeiTuoJingMaiActivity extends BaseActivity {


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

    @Override
    protected int getResId() {
        return R.layout.common;
    }

    MeWeiTuoAdapter adapter;
    @Override
    protected void initView() {
        super.initView();
        setText(ttitle,"委托卖房");
        setText(subtitle,"新增委托");

        hide(subtitle);
        adapter = new MeWeiTuoAdapter(R.layout.weituo_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        CommonApi.getInstance().wtsell(getToken(),page,2,this,LIST,true);
    }

    @OnClick({R.id.back,R.id.subtitle})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.subtitle:
                //start(AddWeiTuoActivity.class);
                break;
        }
    }
    protected List<QiTeBean> list;
    protected CommonListBean<QiTeBean> listData;
    @Override
    public void success(int requestcode, Base base) {
        super.success(requestcode, base);
        switch (requestcode){
            case LIST:
                listData = (CommonListBean)base;
                list = listData.data;
                if(list!=null && list.size()>0){
                    adapter.addData(list);
                }
                break;

            case REFRESHBASE:
                listData = (CommonListBean)base;
                list.clear();
                list.addAll(listData.data);
                if(list!=null && list.size()>0){
                    adapter.replaceData(list);
                }
                refresh.finishRefresh();
                break;
            case LOADMOREBASE:
                listData = (CommonListBean)base;
                list.addAll(listData.data);
                if(list!=null && list.size()>0){
                    adapter.replaceData(list);
                }
                refresh.finishLoadmore();
                break;
        }
    }

    @Override
    protected void initListener() {
        super.initListener();
        refresh.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                CommonApi.getInstance().wtsell(getToken(),++page,2,WeiTuoJingMaiActivity.this,LOADMOREBASE,true);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                CommonApi.getInstance().wtsell(getToken(),1,2,WeiTuoJingMaiActivity.this,REFRESHBASE,true);
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(WeiTuoJingMaiActivity.this,MaiFangDetailActivity.class);
                intent.putExtra("id",list.get(position).getLife_id());
                startActivity(intent);
            }
        });
    }
}
