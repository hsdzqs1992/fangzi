package com.zhuye.ershoufang.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/3 0003.
 */

public class ToastUtils {

    public static void toast(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }


}
