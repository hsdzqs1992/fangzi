package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/3/23 0023.
 */

public class MyToolBar extends Toolbar  {

    public MyToolBar(Context context) {
        this(context,null);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.header,null);
        back = view.findViewById(R.id.back);
        title = view.findViewById(R.id.ttitle);
        subtitle = view.findViewById(R.id.subtitle);
        addView(view);
        title.setVisibility(GONE);
        subtitle.setVisibility(GONE);
    }

    public void setTitle(String content){
        title.setVisibility(VISIBLE);
        title.setText(content);
    }


    public void setSubtitle(String content){
        subtitle.setVisibility(VISIBLE);
        subtitle.setText(content);
    }

    public ImageView back ;
    public TextView title ;
    public TextView subtitle ;

    public void clickSubtitle(){
        //subtitle.setOnClickListener();
    }

//    @Override
//    public void onClick(View view) {
//        if(view.getId() == R.id.subtitle){
//            if(subtitle.getVisibility() == GONE){
//
//            }
//        }
//    }
}
