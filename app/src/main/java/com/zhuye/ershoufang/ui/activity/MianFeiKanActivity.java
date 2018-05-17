package com.zhuye.ershoufang.ui.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MianFeiKanAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.MeKanFangBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.ui.activity.me.AddMianFeiKanActivity;
import com.zhuye.ershoufang.ui.activity.me.EditMianFeiActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MianFeiKanActivity extends Common2Activity<MeKanFangBean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.header)
    ClassicsHeader header;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.xinzeng)
    Button xinzeng;

    @Override
    protected int getResId() {
        return R.layout.activity_mian_fei_kan;
    }

    @Override
    protected void initView() {
        super.initView();
        adapter = new MianFeiKanAdapter(R.layout.me_mianfeikan_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        setText(ttitle,"免费看房");
        hide(subtitle);
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);

    }

    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().mianview_list(getToken(),page,MianFeiKanActivity.this,LIST);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

    }

    @OnClick({R.id.back, R.id.xinzeng})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.xinzeng:
                start(AddMianFeiKanActivity.class);
                break;
        }
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().mianview_list(getToken(),++page,MianFeiKanActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().mianview_list(getToken(),1,MianFeiKanActivity.this,REFRESHBASE);
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.zhiding:

                        break;
                    case R.id.edit:
//                        start(EditMianFeiActivity.class);
                        Intent intent = new Intent(MianFeiKanActivity.this,EditMianFeiActivity.class);
                        //intent.putExtra("id",list.get(position).);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
