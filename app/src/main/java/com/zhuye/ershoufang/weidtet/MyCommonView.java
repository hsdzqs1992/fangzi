package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class MyCommonView extends LinearLayout {
    public MyCommonView(Context context) {
        this(context,null);
    }

    public MyCommonView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyCommonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.inputtext);
        int res =  typedArray.getResourceId(R.styleable.inputtext_resid,0);
        typedArray.recycle();
        addView(LayoutInflater.from(context).inflate(res,null));
    }
}
