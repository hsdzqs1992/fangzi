package com.zhuye.ershoufang.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class CheckUtils {
    public static void checkEmpty(Context context , EditText et,String content){
        Toast.makeText(context,TextUtils.isEmpty(et.getText().toString().trim()) ? content:"",Toast.LENGTH_SHORT).show(); ;
    }

}
