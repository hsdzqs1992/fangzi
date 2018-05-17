package com.zhuye.ershoufang.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.home.SelectAdapter;
import com.zhuye.ershoufang.base.BaseActivity;
import com.zhuye.ershoufang.bean.SelectBean;

import java.util.List;

public abstract class HomeWindowActivity extends BaseActivity {


    protected PopupWindow popupWindow;
    private int selectIndex = -1;
    View vie;
    RecyclerView wheelView;
    SelectAdapter adapter;
    TextView queding;
    @Override
    protected void initView() {
        super.initView();
        vie = View.inflate(HomeWindowActivity.this, R.layout.picker2, null);
        adapter = new SelectAdapter(R.layout.select_item);
        wheelView = vie.findViewById(R.id.select);
        queding = vie.findViewById(R.id.queding);
        wheelView.setAdapter(adapter);
        wheelView.setLayoutManager(new LinearLayoutManager(this));

    }

    //TextView target, String title, int type,int resId
    protected void alertWindow(View view, List<SelectBean> data) {
        selectIndex = -1;
        popupWindow = new PopupWindow(HomeWindowActivity.this);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        adapter.replaceData(data);
        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            }
        });


        popupWindow.showAsDropDown(view);
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(popupWindow!=null &&popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                dianjiItem(position);
            }
        });
    }

    private void dianjiItem(int position) {

    }
}
