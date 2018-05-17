package com.zhuye.ershoufang.weidtet;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.zhuye.ershoufang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11 0011.  右侧有textview的选择框
 */

public class MyTvSelectView extends LinearLayout {
    private  Context context;
    private List<DataBean> data = new ArrayList<>();

    public MyTvSelectView(Context context) {
        this(context,null);
    }


    public MyTvSelectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    TextView textView1;
    TextView textView2 ;
    public MyTvSelectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.selectview2,null);
        textView1 = view.findViewById(R.id.name);
        textView2 = view.findViewById(R.id.name1);

//        LinearLayout.LayoutParams params = (LayoutParams) getLayoutParams();
//        params.height = 45;
        addView(view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTvSelectView);
        String hint = typedArray.getString(R.styleable.MyTvSelectView_tv1);
        tx1 = typedArray.getString(R.styleable.MyTvSelectView_tv2);
        typedArray.recycle();
        textView1.setText(hint);
        textView2.setText(tx1);
        this.context = context;

        initListener();
        vie = View.inflate(context, R.layout.picker, null);
        vie.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
    }

    private void initListener() {
        textView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.size()==0){
                    return;
                }
                editLeiXing((TextView) view);
            }
        });
    }

    String tx1;

    PopupWindow popupWindow;


    private int selectIndex = -1;
    public String getString(){
        return textView2.getText().toString().trim();
    }

    public Boolean isChange(){
        if(textView2.getText().toString().trim().equals(tx1)){
            Toast.makeText(context,"请输入"+tx1,Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    public void setData(String... args){
        List<DataBean> dataBeans = new ArrayList<>();
        int items = args.length/2;
        // 0  1  2
        // 1  3  5
        for (int i = 0; i<items ;i++){
            DataBean dataBean = new DataBean(Integer.parseInt(args[i*2+1]),args[2*(i+1)]);
            dataBeans.add(dataBean);
        }

//        DataBean dataBean = new DataBean(1,"期房未收");
//        DataBean dataBean2 = new DataBean(2,"期房在售");
//        DataBean dataBean3 = new DataBean(3,"期房已售完");
//        dataBeans.add(dataBean);
//        dataBeans.add(dataBean2);
//        dataBeans.add(dataBean3);
        this.data = dataBeans;
    }
    public void setData(List<DataBean> data){
        this.data = data;
    }

    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity)context).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity)context).getWindow().setAttributes(lp);
    }


    public int getId(){
        int i = 0;
        String cur = textView2.getText().toString().trim();
        for (DataBean dataBean : data){
            if(dataBean.name.equals(cur)){
                i = dataBean.id;
                break;
            }
        }
        return i;
    }
    View vie;
    private void editLeiXing(TextView target) {
        selectIndex = -1;
        popupWindow = new PopupWindow(context);
        popupWindow.setContentView(vie);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度
        WheelView wheelView = vie.findViewById(R.id.wheel);
        TextView queding = vie.findViewById(R.id.queding);

        wheelView.setCyclic(false);

        final List<String> mOptionsItems = new ArrayList<>();

        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                target.setText(data.get(selectIndex).name);
//                if (selectIndex != -1) {
//                    target.setText(mOptionsItems.get(selectIndex));
//                    // 是省的类型  且选中状态
//                    if (type == 6) {
//                        CommonApi.getInstance().xiaji(getIndex(cityBean, mOptionsItems.get(selectIndex)), AddErShouActivity.this, XIAJI, false);
//                    } else if (type == 7) {
//                        CommonApi.getInstance().xiaji(getIndex(xiaji, mOptionsItems.get(selectIndex)), AddErShouActivity.this, QU, false);
//                    } else if (type == 8) {
//                        CommonApi.getInstance().xiaji(getIndex(qu, mOptionsItems.get(selectIndex)), AddErShouActivity.this, JIEDAO, false);
//                    }
//                }

            }
        });

        List<String> dat = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            dat.add(data.get(i).name);
        }
//        switch (type) {
//            case 1:
//                for (int i = 0; i < faBuSelectBean.getData().get房屋类型().size(); i++) {
//                    data.add(faBuSelectBean.getData().get房屋类型().get(i).getAttr_name());
//                }
//                break;
//            case 2:
//                for (int i = 0; i < faBuSelectBean.getData().get装修程度().size(); i++) {
//                    data.add(faBuSelectBean.getData().get装修程度().get(i).getAttr_name());
//                }
//                break;
//            case 3:
//                for (int i = 0; i < faBuSelectBean.getData().get年代().size(); i++) {
//                    data.add(faBuSelectBean.getData().get年代().get(i).getAttr_name());
//                }
//                break;
//            case 4:
//                for (int i = 0; i < faBuSelectBean.getData().get朝向().size(); i++) {
//                    data.add(faBuSelectBean.getData().get朝向().get(i).getAttr_name());
//                }
//                break;
//
//            case 11:
//                for (int i = 0; i < xiaoqua.getData().size(); i++) {
//                    data.add(xiaoqua.getData().get(i).getXiaoqu());
//                }
//                break;
//            case 6:
//                for (int i = 0; i < cityBean.getData().size(); i++) {
//                    data.add(cityBean.getData().get(i).getName());
//                }
//                break;
//            case 7:
//                for (int i = 0; i < xiaji.getData().size(); i++) {
//                    data.add(xiaji.getData().get(i).getName());
//                }
//                break;
//            case 8:
//                if (qu == null) {
//                    return;
//                }
//                for (int i = 0; i < qu.getData().size(); i++) {
//                    data.add(qu.getData().get(i).getName());
//                }
//                break;
//
//            case 9:
//                if (jiedao == null) {
//                    return;
//                }
//                for (int i = 0; i < jiedao.getData().size(); i++) {
//                    data.add(jiedao.getData().get(i).getName());
//                }
//                break;
//
//        }


        mOptionsItems.addAll(dat);
        wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                // Toast.makeText(AddErShouActivity.this, "" + mOptionsItems.get(index), Toast.LENGTH_SHORT).show();
                selectIndex = index;
            }
        });
//        vie.findViewById(R.id.gongyechang).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                }
//                start(AddGongChangActivity.class);
//            }
//        });
        //popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        popupWindow.showAtLocation(vie, Gravity.BOTTOM, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }
}
