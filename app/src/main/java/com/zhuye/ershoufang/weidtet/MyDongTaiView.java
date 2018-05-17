package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhuye.ershoufang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * // TODO: 2018/5/11 0011    android  自定义动态布局
 */

public class MyDongTaiView extends RelativeLayout {

    public MyDongTaiView(Context context) {
        this(context,null);
    }

    public MyDongTaiView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    private List<View> views = new ArrayList<>();


    private Context  mContect;
    private int resid ;
    private RelativeLayout rootview;
    View view1;
    public MyDongTaiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.myDongTaiView);
        int res =  typedArray.getResourceId(R.styleable.myDongTaiView_reid,0);
        typedArray.recycle();
        view1 = LayoutInflater.from(context).inflate(res,null);
        rootview = view1.findViewById(R.id.rootview);
        addView(view1);
        views.add(view1);
        mContect = context;
        resid = res;
    }

    public void addView(int positon){

       // for()
        //removeView(v);
//        for (View v : views){
//            addView(v);
//           removeView(v);
//        }
//
//        View view =  views.get(0);
//
//        views.add(positon,view);
//        for (View v : views){
//            addView(v);
//        }


        View view= LayoutInflater.from(mContect).inflate(resid,null);

        //// TODO: 2018/5/11 0011  得不到高度
        int height=  view1.getHeight();
        int width =  view1.getWidth();

        RelativeLayout.LayoutParams paramss = (LayoutParams) view1.getLayoutParams();
        paramss.width = 45;
        view1.setLayoutParams(paramss);


        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();

        params.height = 300;

       // params.weight = width;
//        Toast.makeText(mContect,height+,Toast.LENGTH_LONG).show();

        setLayoutParams(params);
        views.add(positon,view);

        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400);
        rootview.setLayoutParams(params1);
        rootview.addView(view);
        //addView(view,views.size()-1);
    }
}
