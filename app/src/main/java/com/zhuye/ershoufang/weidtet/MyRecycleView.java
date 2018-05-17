package com.zhuye.ershoufang.weidtet;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Toast;

import com.zhuye.ershoufang.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/12 0012.
 */

public class MyRecycleView extends RecyclerView {

    public MyRecycleView(Context context) {
        this(context,null);
    }


    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RvAdapter2 adapter2;

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        adapter2 = new RvAdapter2(R.layout.myrv_item);
        setAdapter(adapter2);
        CustomLinearLayoutManager layoutManager =  new CustomLinearLayoutManager(context);
        setLayoutManager(layoutManager);

        layoutManager.setScrollEnabled(false);

        MyRecycleBean bean = new MyRecycleBean(null,"","");
        datas.add(bean);
        adapter2.addData(datas);
        this.context = context;
    }

    public List<MyRecycleBean> datas = new ArrayList<>();
    public void setData(MyRecycleBean bean,int pos){
        datas.add(pos,bean);

    }

    public void add(){
        datas.add(new MyRecycleBean(null,"",""));
        adapter2.replaceData(datas);
    }
    Context context;

    public Boolean isTian(){
        int count = adapter2.getItemCount();
        Boolean temp = true;
        for (int i = 0;i<count;i++){
            MyRecycleBean bean = adapter2.getItem(i);
            if(bean.filepath==null||bean.filepath.size()==0){
                Toast.makeText(context,"请上传"+(i+1)+"户型图片",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
            if(TextUtils.isEmpty(bean.miaoshua)){
                Toast.makeText(context,"请上传"+(i+1)+"户型描述",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
            if(TextUtils.isEmpty(bean.mian)){
                Toast.makeText(context,"请上传"+(i+1)+"户型面积",Toast.LENGTH_SHORT).show();
                temp = false;
                break;
            }
        }
        //adapter2.
        return temp;
    }
}
