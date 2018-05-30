package com.zhuye.ershoufang.ui.activity;

import android.view.View;

import com.zhuye.ershoufang.bean.Base;
import com.zhuye.ershoufang.bean.CityBean;
import com.zhuye.ershoufang.data.CommonApi;
import com.zhuye.ershoufang.ui.activity.home.CommonHomeActivity;

public abstract class CommonHome5Activity<T> extends CommonHomeActivity<T> {



    protected static final int GETDATA = 555;


    protected String business_id = null;
    protected String prices1;
    protected String prices2;
    protected String select1;
    protected  String yonghu;
    protected String qu_id;
    @Override
    protected void initData() {
        super.initData();
        qu_id = getQuId();
        CommonApi.getInstance().xiaji(qu_id,CommonHome5Activity.this,GETDATA,false);
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


    public void getData(String cate_id){
        CommonApi.getInstance().index(cate_id,qu_id,page,business_id,prices1,prices2,select1,yonghu,"",
                CommonHome5Activity.this,LIST);
    };

    public void selecechoose(String cate_id,int code){
        switch (code){
            case REFRESHBASE:
                page = 1;
                break;

            case LOADMOREBASE:
                ++page;
                break;
        }
        CommonApi.getInstance().index("3",qu_id,page,business_id,prices1,prices2,select1,yonghu,"",
                CommonHome5Activity.this,code);
    }

    @Override
    public void getClickPrice(String price1, String price2) {
        super.getClickPrice(price1, price2);
        prices2 = price2;
        prices1 = price1;
        selecechoose("3",REFRESHBASE);
    }


}
