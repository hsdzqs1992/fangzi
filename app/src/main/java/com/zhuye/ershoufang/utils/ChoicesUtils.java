package com.zhuye.ershoufang.utils;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class ChoicesUtils  {

    public static int type = 0;
    public static int count;

    public static List<View> choiceView = new ArrayList<>();
    public static List<Integer> choiceid = new ArrayList<>();
    public static List<Integer> choiceselView = new ArrayList<>();


    //单选处理
    public static void change() {
        for (int i =0 ;i<count;i++){
           if(i == type-1){
               //todo
               choiceView.get(i).setBackgroundResource(choiceselView.get(i));
           }else {
               choiceView.get(i).setBackgroundResource(choiceid.get(i));
           }
        }
    }

    public static void clear(){
        choiceView.clear();
        choiceid.clear();
        choiceselView.clear();
    }
}
