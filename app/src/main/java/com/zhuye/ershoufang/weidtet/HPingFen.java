package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhuye.ershoufang.R;

import java.util.ArrayList;
import java.util.List;

/**
 *  水平平分的  布局父类容器
 * s使用时 需传入子类的 布局 数据
 *  自定义控件  仿照流式布局
 *
 */
public class HPingFen extends LinearLayout {
    public HPingFen(Context context) {
        this(context,null);
    }

    public HPingFen(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    protected Context context;
    public HPingFen(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
//        View view = LayoutInflater.from(context).inflate(R.layout.tv,null);
//        for (int i = 0;i<4;i++){
//            addView(view);
//            //views.add(view);
//        }

//        for (int i = 0;i<4;i++){
//            View view = LayoutInflater.from(context).inflate(R.layout.tv,null);
//            addView(view);
//        }

    }

    private List<View> views = new ArrayList<>();
    public void setData(int resId, List data){
        View view = LayoutInflater.from(context).inflate(resId,null);
        for (int i = 0;i<data.size();i++){
            addView(view);
            views.add(view);
        }
        setGravity(Gravity.CENTER);
    }
    public void setData(int resId, int data){
        for (int i = 0;i<data;i++){
            View view = LayoutInflater.from(context).inflate(resId,null);


           RelativeLayout ll =  view.findViewById(R.id.con);
            ll.setMinimumWidth(getWidth()/data);
           RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ll.getLayoutParams();
//            params.width = getWidth()/data;
//            view.setLayoutParams(params);
            //// TODO: 2018/3/23 0023 设置宽度
            Log.i("asd",params+"");


            addView(view);
            views.add(view);


        }

        setGravity(Gravity.CENTER);
    }

}
