package com.zhuye.ershoufang.ui.activity.home;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.Common2Adapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CommonBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;
import com.zhuye.ershoufang.utils.CheckUtil;
import com.zhuye.ershoufang.utils.WindowUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class YouHuiActivity extends Common2Activity<CommonBean> {


    private static final int SUBMIT = 987;
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

    @Override
    protected void initView() {
        super.initView();
        hide(subtitle);
        setText(ttitle,"优惠活动");
        adapter = new Common2Adapter(R.layout.youhui_item);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));


        input = View.inflate(YouHuiActivity.this, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);

    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().activity(getQuId(),
                1,page,YouHuiActivity.this
                ,LIST);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public BaseQuickAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case SUBMIT:
                toast(o.getMessage());
                break;
        }
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    @Override
    protected void onLoadmore() {
        CommonApi.getInstance().activity(getQuId(),
                1,++page,YouHuiActivity.this
                ,LOADMOREBASE);
    }

    @Override
    protected void onRefresh() {
        CommonApi.getInstance().activity(getQuId(),
                1,1,YouHuiActivity.this
                ,REFRESHBASE);
    }

    PopupWindow popupWindow2;
    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;
    private int selectIndex;
    private void editLeiXingin(View view, TextView target, String title, int type) {
        selectIndex = -1;
        popupWindow2 = new PopupWindow(YouHuiActivity.this);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        WindowUtils.setBackgroundAlpha(YouHuiActivity.this, 0.5f);//设置屏幕透明度
        inputtitle.setText(title);

        inputquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow2.isShowing()) {
                    popupWindow2.dismiss();
                }
            }
        });

        inputqueding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (checkEmpty(inputcontent, "请输入内容")) {
//
//                }

                if(CheckUtil.isMobile(YouHuiActivity.this,getString(inputcontent))){
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        // target.setText(getString(inputcontent));
                        CommonApi.getInstance().discount(getToken(),list.get(type).getLife_id(),getString(inputcontent),YouHuiActivity.this
                        ,SUBMIT);
                    }
                }
            }
        });

        popupWindow2.showAtLocation(view, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                WindowUtils.setBackgroundAlpha(YouHuiActivity.this, 1.0f);
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.price:
                        editLeiXingin(view,null,"请输入手机号",position);
                        break;
                }
            }
        });
    }
}
