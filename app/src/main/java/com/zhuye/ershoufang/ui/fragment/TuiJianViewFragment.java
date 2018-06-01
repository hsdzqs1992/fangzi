package com.zhuye.ershoufang.ui.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhuye.ershoufang.R;
import com.zhuye.ershoufang.adapter.AlertAdapter;
import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.data.CommonApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public abstract class TuiJianViewFragment<T> extends CommonFragment<T> {
    protected static final int GETDATA = 948;
    @BindView(R.id.recycle)
    protected RecyclerView recycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    Unbinder unbinder;
    protected String business_id;
    protected String prce1;
    protected String prce2;
    protected String select1;
    protected String yonghu;
    @BindView(R.id.quyu)
    LinearLayout quyu;
    @BindView(R.id.jiage)
    LinearLayout jiage;
    @BindView(R.id.huxing)
    LinearLayout huxing;
    @BindView(R.id.video)
    LinearLayout video;
    Unbinder unbinder1;


    @Override
    protected int getResId() {
        return R.layout.bodytuijian;
    }


    @Override
    protected void initData() {
        super.initData();
        CommonApi.getInstance().xiaji(getQuId(), TuiJianViewFragment.this, GETDATA, false);
    }


    @Override
    public BaseQuickAdapter getAdapter() {
        return adapte;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return refresh;
    }

    protected CityBean jiadao;

    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode) {
            case GETDATA:
                jiadao = (CityBean) o;
                break;
        }
    }

    protected PopupWindow popupWindow2;

    protected void alertjiageWindow(View view, int rescode) {
        View vie = View.inflate(getActivity(), R.layout.jiage, null);
        popupWindow2 = new PopupWindow(getActivity());
        popupWindow2.setContentView(vie);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);
        TextView tv1 = vie.findViewById(R.id.queding);
        TextView tv2 = vie.findViewById(R.id.quxiao);
        EditText et1 = vie.findViewById(R.id.dijia);
        EditText et2 = vie.findViewById(R.id.gaojia);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(getString(et1))&&TextUtils.isEmpty(getString(et2))){
                    toast("请输入低价");
                }else {
                    if(popupWindow2!=null && popupWindow2.isShowing()){
                        popupWindow2.dismiss();
                    }
                    prce1 = getString(et1);
                    prce2 = getString(et2);
                    //getClickPrice(getString(et1),getString(et2));
                }
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(popupWindow2!=null && popupWindow2.isShowing()){
                    popupWindow2.dismiss();
                }
            }
        });
        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        popupWindow2.showAsDropDown(view,0,15 );
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    @OnClick({R.id.quyu, R.id.jiage, R.id.huxing, R.id.video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quyu:
                dat.clear();
                clickJieDao(view);
                break;
            case R.id.jiage:
                alertjiageWindow(view,100);
                break;
            case R.id.huxing:
                clickhuxing(view);
                break;
            case R.id.video:
                dat.clear();
                dat.add("有视频");
                dat.add("无视频");
                alertWindow(view, dat, 14);
                break;
        }
    }

    protected abstract void clickhuxing(View view);

    protected List<String> dat = new ArrayList<>();
    private void clickJieDao(View view) {
        if(jiadao==null){
            return;
        }
        for (int i =0;i<jiadao.getData().size();i++){
            dat.add(jiadao.getData().get(i).getName());
        }
        alertWindow(view, dat, 9);
    }
    protected RecyclerView recyclerView;
    AlertAdapter alertAdapter;
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    protected void alertWindow(View view, List<String> da, int rescode) {
        View vie = View.inflate(getActivity(), R.layout.rv, null);
        popupWindow = new PopupWindow(getActivity());
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        alertAdapter = new AlertAdapter(R.layout.alert_item);
        recyclerView = vie.findViewById(R.id.rv);
        recyclerView.setAdapter(alertAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        alertAdapter.addData(da);
        alertAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (popupWindow!=null&popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
                switch (rescode){
                    case 9:
                        business_id = jiadao.getData().get(position).getId();
                        toast(jiadao.getData().get(position).getName());
                        break;
                    case 11:
                        select1 = position+1+"";
                        break;

                    case 14:

                        break;
                }

               // TuiJianViewFragment.this.onItemClick(view,position,rescode);
            }
        });
        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度
//        vie.findViewById(R.id.shouru).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                start(AddErShouActivity.class);
//                type = 0;
//
//            }
//        });
//        vie.findViewById(R.id.tixian).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                start(AddXieZiActivity.class);
//                type = 0;
//
//            }
//        });
//
//        vie.findViewById(R.id.shangpu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                //title.setText("收入记录");
//                type = 0;
//                start(AddShangPuActivity.class);
//            }
//        });
//
//        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                start(AddGongChangActivity.class);
//            }
//        });

        popupWindow.showAsDropDown(view,0,15 );
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        //popupWindow.showAtLocation(vie, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }
    protected void  onItemClick(View view, int position, int rescode){
    }
    protected PopupWindow popupWindow;

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().setAttributes(lp);
    }
}
