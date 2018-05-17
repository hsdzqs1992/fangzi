package com.zhuye.ershoufang.utils;

import android.app.Activity;
import android.view.WindowManager;

/**
 * Created by Administrator on 2018/4/27 0027.
 */

public class WindowUtils {
    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public static void setBackgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().setAttributes(lp);
    }

}
