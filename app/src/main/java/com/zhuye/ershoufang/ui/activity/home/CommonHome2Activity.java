package com.zhuye.ershoufang.ui.activity.home;

import android.view.View;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.common.Common2Activity;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonHome2Activity<T> extends Common2Activity<T> {

    private static final int GETDATA = 1999;
    protected String qu_id;
    @Override
    protected void initData() {
        super.initData();
        qu_id = getQuId();
        CommonApi.getInstance().xiaji(qu_id,CommonHome2Activity.this,GETDATA,false);
    }

    protected CityBean jiadao;
    @Override
    public void success(int requestcode, Base o) {
        super.success(requestcode, o);
        switch (requestcode){
            case GETDATA:
                jiadao = (CityBean) o;
                break;
        }
    }

    protected List<String> dat = new ArrayList<>();
    public void clickJieDao(View view){
        if(jiadao==null){
            return;
        }
        for (int i =0;i<jiadao.getData().size();i++){
            dat.add(jiadao.getData().get(i).getName());
        }
        alertWindow(view, dat, 9);
    }


    public void clickLeiXing(View view){
        dat.add("住宅");
        dat.add("商铺");
        dat.add("写字楼");
        dat.add("工业厂房");
        alertWindow(view, dat, 11);
    }

    protected String business_id;


}
