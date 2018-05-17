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
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.WenDaDetailAdapter;
import com.zhuye.ershoufang.bean.AnswerBean;
import com.zhuye.ershoufang.bean.AnswerBean2;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonObjectBean;
import com.zhuye.ershoufang.bean.WenDadetailBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WenDaDetailActivity extends Common2Activity<AnswerBean2> {


    private static final int GETDATA = 999;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.tiwen)
    TextView tiwen;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.answer)
    Button answer;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    @Override
    protected int getResId() {
        return R.layout.activity_wen_da_detail;
    }

    String id;

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle, "问题详情");
        id = getIntent().getStringExtra("id");
        CommonApi.getInstance().questiondetail(Integer.parseInt(id), this, GETDATA);
        CommonApi.getInstance().answer(Integer.parseInt(id), page, this, LIST, false);
        adapter = new WenDaDetailAdapter(R.layout.wenda_detail_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));
    }

    CommonObjectBean<WenDadetailBean> bean;

    List<AnswerBean2>  listData;
    List<AnswerBean2>  list;
    CommonObjectBean<AnswerBean<AnswerBean2>> temp;
    @Override
    public void success(int requestcode, Base base) {
        switch (requestcode) {
            case GETDATA:
                bean = (CommonObjectBean<WenDadetailBean>) base;
                tiwen.setText(bean.getData().getQuestion());
                time.setText(bean.getData().getCreate_time());
                break;
            case LIST:
                temp = (CommonObjectBean<AnswerBean<AnswerBean2>>) base;
                listData = temp.getData().getAnswer();
                if(listData!=null && listData.size()>0){
                    getAdapter().addData(listData);
                }
                break;

            case REFRESHBASE:
                temp = (CommonObjectBean<AnswerBean<AnswerBean2>>) base;
                listData = temp.getData().getAnswer();
                // TODO: 2018/5/9 0009 反复试youbug
                if(listData!=null && listData.size()>0){
                    listData.clear();
                    getAdapter().replaceData(listData);
                }
                getSmartRefreshLayout().finishRefresh();
                break;
            case LOADMOREBASE:
                temp = (CommonObjectBean<AnswerBean<AnswerBean2>>) base;
               // listData = temp.getData().getAnswer();
                if(listData!=null && listData.size()>0){
                   // list.addAll(listData.data);
                    listData.addAll(temp.getData().getAnswer());
                    if(listData!=null && listData.size()>0){
                        getAdapter().replaceData(listData);
                    }
                }
                getSmartRefreshLayout().finishLoadmore();
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
        CommonApi.getInstance().answer(Integer.parseInt(id), ++page, this, LOADMOREBASE, true);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().answer(Integer.parseInt(id), 1, this, REFRESHBASE, true);
    }

    @OnClick({R.id.back, R.id.answer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.answer:
                Intent intent = new Intent(WenDaDetailActivity.this, AnswerActivity.class);
                intent.putExtra("id", bean.getData().getId());
                intent.putExtra("title", bean.getData().getQuestion());
                startActivity(intent);
                break;
        }
    }

}
