package com.zhuye.ershoufang.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhuye.ershoufang.R;

/**
 * 消息弹窗的处理
 */

public class PopWindowUtils {

    public static PopupWindow popupWindow;

    /**
     *
     * @param context
     * @param pos  显示的位置
     * @param content  内容
     * @param click  点击事件吃力
     */
    public static void showWindow(Context context,View pos , String content,OnPclick click){
        popupWindow = new PopupWindow(context);
        popupWindow.setWidth(250);
        popupWindow.setHeight(200);

        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



        View view = View.inflate(context,0,null);
        TextView textView =  view.findViewById(R.id.tab_tv);
        textView.setText(content);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click.onclick(view);
                hide();
                click.onclick(view);
                click.cancle(view);
            }
        });
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(pos, Gravity.BOTTOM,0,0);
    }

    public static void hide(){
        if(popupWindow !=null && popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }


    public interface OnPclick{
        void onclick(View view);
        void cancle(View view);
    }
}
