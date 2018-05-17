package com.zhuye.ershoufang.data;

import com.zhuye.ershoufang.bean.Base;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public class GetData {

//    public static void getCode(String mobile,BaseView baseView,int requestcode){
//        CommonApi.getInstance().getCode(mobile).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode) {
//            @Override
//            public void onNext(Base base) {
//                if (base.getCode()==200){
//                    baseView.success(requestcode,base);
//                }else {
//                    baseView.error(base);
//                }
//                baseView.finishLoding();
//            }
//        });
//    }
//
//    public static void getCode2(String mobile,BaseView baseView,int requestcode){
//        // TODO: 2018/3/27 0027  线程切换的代码  多余   操作符
//        CommonApi.getInstance().getCode(mobile).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode) {
//        });
//    }


    // 公共处理方法
    public static void sub(Observable observable,BaseView baseView, int requestcode){
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode));
    }

    public static void getCode3(String mobile, BaseView baseView, int requestcode){
        // TODO: 2018/3/27 0027  线程切换的代码  多余   操作符 流式操作   四步可能会多一点
        // 装饰一下
        GetData.sub(CommonApi.getInstance().getCode(mobile),baseView,requestcode);
       // return this;
     }

    public static void getRegeister(String mobile , String password, String zpassword, String  code ,int type, BaseView baseView,int requestcode){
        // TODO: 2018/3/27 0027  线程切换的代码  多余   操作符 流式操作   四步可能会多一点
        GetData.sub(CommonApi.getInstance().getRegeister(mobile,password,zpassword,code,type),baseView,requestcode);
    }


    public static void upimg(String token , File filepath, BaseView baseView, int requestcode){
        CommonApi.getInstance().upimg(token,filepath).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode));
    }

    public static void user_data(String token,String true_name,String card
            , String card_img,int main_business,String scope_work,String license,String city_id,String shop, BaseView baseView, int requestcode){
        CommonApi.getInstance().user_data(token,true_name,card,card_img,main_business,scope_work,license,city_id,shop).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new MyObserver<Base>(baseView,requestcode));
    }

    public static void login(String mobile, String password, BaseView baseView,int requestcode){
        // TODO: 2018/3/27 0027  线程切换的代码  多余   操作符 流式操作   四步可能会多一点
        GetData.sub(CommonApi.getInstance().login(mobile,password),baseView,requestcode);
    }


}
