package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuye.ershoufang.R;

/**
 * Created by Administrator on 2018/5/14 0014.
 */

public class  MyLinTv2View extends LinearLayout {
    public MyLinTv2View(Context context) {
        this(context,null);
    }

    public MyLinTv2View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    TextView textView1;
    EditText textView2;
    public MyLinTv2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.mylintv2,null);
        textView1 = view.findViewById(R.id.tvs);
        textView2 = view.findViewById(R.id.tvs2);
        addView(view);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyLinTv2View);
        String hint = typedArray.getString(R.styleable.MyLinTv2View_title11);
         tx1= typedArray.getString(R.styleable.MyLinTv2View_tishi11);
        int   lines= typedArray.getInteger(R.styleable.MyLinTv2View_lines,1);
        typedArray.recycle();
        textView1.setText(hint);
        textView2.setHint(tx1);

        textView2.setLines(lines);
        this.context = context;
    }
    String tx1;
    private Context context;
    public Boolean getString(){
        if(TextUtils.isEmpty(textView2.getText().toString().trim())){
            Toast.makeText(context,tx1,Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    public String getContent(){
        return textView2.getText().toString().trim();
    }

    public void setContext(String context){
        textView2.setText(context);
    }

}
