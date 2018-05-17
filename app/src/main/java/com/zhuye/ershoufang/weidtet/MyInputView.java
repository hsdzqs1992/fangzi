package com.zhuye.ershoufang.weidtet;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuye.ershoufang.R;

import cn.qqtheme.framework.picker.DateTimePicker;

/**
 * Created by Administrator on 2018/5/10 0010.
 * // TODO: 2018/5/10 0010  实现动态布局
 *        事件处理
 *
 *        功能
 *        使用
 */

public class MyInputView extends LinearLayout {

    public MyInputView(Context context) {
        this(context,null);
    }

    public MyInputView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    TextView textView1;
    EditText editText;
    TextView textView2 ;
    ImageView go;
    LinearLayout rootview;
    private Context context;
    public MyInputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.inputview,null);
        textView1 = view.findViewById(R.id.shifa1);
        editText = view.findViewById(R.id.mianji);
        textView2 = view.findViewById(R.id.leixing);
        rootview = view.findViewById(R.id.rootview);
        go = view.findViewById(R.id.go);
        addView(view);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.inputtext);
        String hint = typedArray.getString(R.styleable.inputtext_hint);
        String tx1 = typedArray.getString(R.styleable.inputtext_tx1);
        String tx2 = typedArray.getString(R.styleable.inputtext_tx2);
        Boolean shows = typedArray.getBoolean(R.styleable.inputtext_show2,false);
        Boolean show4 = typedArray.getBoolean(R.styleable.inputtext_show4,false);
        typedArray.recycle();
        editText.setHint(hint);
//        显示箭头隐藏文字
        if(show4){
            go.setVisibility(VISIBLE);
            textView2.setVisibility(GONE);
            editText.setClickable(false);
            editText.setFocusable(false);
        }else {
            go.setVisibility(GONE);
            textView2.setVisibility(VISIBLE);
        }
        editText.setVisibility(shows ? GONE:VISIBLE);
        textView1.setText(tx1);
        textView2.setText(tx2);

        rootview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClick!=null)
                onClick.onClick(view);
            }
        });

        go.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(onClick!=null){
                    onClick.onClick(view);
                }else {
                    selectTime();
                }
            }
        });
    }

    private void selectTime() {
        DateTimePicker picker = new DateTimePicker((Activity) context, DateTimePicker.HOUR_24);
        picker.setDateRangeStart(2017, 1, 1);
        picker.setDateRangeEnd(2025, 11, 11);
        picker.setTimeRangeStart(9, 0);
        picker.setTimeRangeEnd(20, 30);
        picker.setTopLineColor(0x99FF0000);
        //picker.setLabelTextColor(0xFFFF0000);
        picker.setDividerColor(0xFFFF0000);
        picker.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() {
            @Override
            public void onDateTimePicked(String year, String month, String day, String hour, String minute) {
                //showToast(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                editText.setVisibility(VISIBLE);
                editText.setClickable(false);
                editText.setFocusable(false);
                editText.setText(year + "-" + month + "-" + day + " " + hour + ":" + minute);
                time = year + "-" + month + "-" + day + " " + hour + ":" + minute;
            }
        });
        picker.show();

    }

    public String getTime(){
        return time;
    }

    public Boolean isTimeChange(){
        return !TextUtils.isEmpty(time);
    }

    private String time;

    public void setText(String text1 ,String text2){
        textView1.setText(text1);
        textView2.setText(text2);
    }

    public EditText getEditText(){
        return editText;
    }

    public Boolean getString(String tishi){
        if(TextUtils.isEmpty(editText.getText().toString().trim())){
            Toast.makeText(context,tishi,Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return true;
        }
    }

    public void setHint(String hint){
        editText.setHint(hint);
    }

    // TODO: 2018/5/10 0010 合并两个方法
    public Boolean getString(){
        if (editText.getHint()!=null){
            return getString(editText.getHint().toString());
        }else {
            return getString("请输入"+editText.getText().toString());
        }

//        return getString(editText.getHint().toString());
    }
    public String getContent(){
        return editText.getText().toString().trim();
    }

    public void setContent(String content){
        editText.setText(content);
    }

    public void setTx2(String content){
        textView2.setText(content);
    }

    public void hideView(){
        hideView(2);
    }

    public void hideView(int pos){
        switch (pos){
            case 1:
                textView1.setVisibility(GONE);
                break;
            case 2:
                editText.setVisibility(GONE);
                break;
            case 3:
                textView2.setVisibility(GONE);
                break;
        }
    }

    private  OnClick onClick;

    public void itemClick(OnClick onClick){
        this.onClick = onClick;
    }

    public interface OnClick{
       void  onClick(View view);
    }

    public void nocanChange(){
        editText.setFocusable(false);
        editText.setClickable(false);
    }

    public void setRightArrow(){
         Drawable you =  context.getResources().getDrawable(R.drawable.you);
         you.setBounds(0, 0, you.getMinimumWidth(), you.getMinimumHeight());
         textView2.setCompoundDrawablePadding(5);
         textView2.setCompoundDrawables(null,null,you,null);
    }

    // TODO: 2018/5/17 0017 输入
    public void setTv2InClick(){
        editLeiXingin(textView2,"",0);
    }
    PopupWindow popupWindow;
    PopupWindow popupWindow2;
    View input;
    TextView inputtitle;
    EditText inputcontent;
    Button inputquxiao;
    Button inputqueding;
    private int selectIndex = -1;
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = ((Activity)context).getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        ((Activity)context).getWindow().setAttributes(lp);
    }
    private void editLeiXingin(TextView target, String title, int type) {
        selectIndex = -1;
        input = View.inflate(context, R.layout.input_text, null);
        inputtitle = input.findViewById(R.id.title);
        inputcontent = input.findViewById(R.id.input);
        inputquxiao = input.findViewById(R.id.quxiao);
        inputqueding = input.findViewById(R.id.queding);
        popupWindow2 = new PopupWindow(context);
        popupWindow2.setContentView(input);
        popupWindow2.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow2.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setFocusable(true);

        // 背景的处理
        setBackgroundAlpha(0.5f);//设置屏幕透明度


        inputtitle.setText(title);

        inputquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (popupWindow2.isShowing()) {
                    popupWindow2.dismiss();
                }
            }
        });

        inputqueding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(inputcontent.getText().toString().trim())){
                    Toast.makeText(context, "请输入内容", Toast.LENGTH_SHORT).show();
                }else {
                    if (popupWindow2.isShowing()) {
                        popupWindow2.dismiss();
                        target.setText(inputcontent.getText().toString().trim());
                    }
                }

            }
        });

        popupWindow2.showAtLocation(this, Gravity.CENTER, 0, 0);
        // popupWindow.showAsDropDown(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
                setBackgroundAlpha(1.0f);
            }
        });
    }

    public String getTx2(){
        return textView2.getText().toString().trim();
    }
}
