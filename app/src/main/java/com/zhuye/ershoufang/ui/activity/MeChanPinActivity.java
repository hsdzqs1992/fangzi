package com.zhuye.ershoufang.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.me.MeChanPinAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.ChanPinBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.ui.activity.me.AddChanPinActivity;
import com.zhuye.ershoufang.utils.Contants;

import butterknife.BindView;
import butterknife.OnClick;

public class MeChanPinActivity extends Common2Activity<ChanPinBean> {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.ttitle)
    TextView ttitle;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.message1)
    ImageView message1;
    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.tijiao)
    Button tijiao;

    @Override
    protected int getResId() {
        return R.layout.activity_me_chan_pin;
    }


    @Override
    protected void initView() {
        super.initView();
        ttitle.setText("产品");
        subtitle.setVisibility(View.INVISIBLE);
        CommonApi.getInstance().jiajulists(getToken(),page,MeChanPinActivity.this,LIST);
    }

    MeChanPinAdapter adapter;
    @Override
    protected void initData() {
        super.initData();
        adapter = new MeChanPinAdapter(R.layout.me_chanpin_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(layoutManager);
        refresh.autoRefresh();
    }




    @OnClick({R.id.back, R.id.tijiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tijiao:
                Intent intent = new Intent(MeChanPinActivity.this,AddChanPinActivity.class);

                intent.putExtra("type",2);
                startActivity(intent);
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
        CommonApi.getInstance().jiajulists(getToken(),++page,MeChanPinActivity.this,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().jiajulists(getToken(),1,MeChanPinActivity.this,REFRESHBASE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh.autoRefresh();
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.bianji:
                        Intent intent = new Intent(MeChanPinActivity.this,AddChanPinActivity.class);
                        intent.putExtra("type",1);
                        intent.putExtra("id",list.get(position).getId());
                        intent.putExtra("photo",list.get(position).getPhoto());
                        startActivity(intent);
                        break;
                    case R.id.delete:
                        alertDialog(position);

                        break;
                    case R.id.zhiding:

                        break;
                }
            }
        });
    }

    private void alertDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MeChanPinActivity.this);
        builder.setTitle("确定删除吗 ?");
        //builder.setMessage("请问你满十八岁了吗?");
       // builder.setIcon(R.mipmap.ic_launcher_round);
        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true);
        //设置正面按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MeChanPinActivity.this, "你点击了是的", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                CommonApi.getInstance().jiajudelete(listData.getData().get(position).getId(),MeChanPinActivity.this,
                        Contants.DELETE);
            }
        });
        //设置反面按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MeChanPinActivity.this, "取消", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //设置中立按钮
//        builder.setNeutralButton("保密", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MeChanPinActivity.this, "你选择了保密", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
        AlertDialog dialog = builder.create();
        //对话框显示的监听事件

        //对话框消失的监听事件

        //显示对话框
        dialog.show();
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case Contants.DELETE:
                // TODO: 2018/5/16 0016
                CommonApi.getInstance().jiajulists(getToken(),1,MeChanPinActivity.this,REFRESHBASE);
                break;
        }
    }
}
