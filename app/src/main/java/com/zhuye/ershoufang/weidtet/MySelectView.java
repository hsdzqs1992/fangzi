package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/5/11 0011.
 */

public class MySelectView extends RelativeLayout {
    TextView textView1;
    TextView textView2 ;

    public MySelectView(Context context) {
        this(context,null);
    }

    public MySelectView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    String name1;
    public MySelectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(context).inflate(R.layout.inputview,null);
        textView1 = view.findViewById(R.id.name);
        textView2 = view.findViewById(R.id.name1);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.selectview);
        String name = typedArray.getString(R.styleable.selectview_name);
        name1 = typedArray.getString(R.styleable.selectview_name1);
        typedArray.recycle();
        addView(view);
        textView1.setText(name);
        textView2.setText(name1);

    }

    public Boolean isChage(){
        if(textView2.getText().toString().trim().equals(name1)){
            return false;
        }else {
            return true;
        }
    }

    public String getName1(){
        return textView2.getText().toString().trim();
    }
}
