package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/5/10 0010.
 * // TODO: 2018/5/10 0010  设置不同的颜色和字体
 */

public class MyTextView extends AppCompatTextView {
    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
}
