package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class SelectPhotoView extends RelativeLayout{
    public SelectPhotoView(Context context) {
        this(context,null);
    }

    public SelectPhotoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SelectPhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
