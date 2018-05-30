package com.zhuye.ershoufang.data;

import com.zhuye.ershoufang.bean.Base;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/11 0011.
 */

public class MyObserver<T extends Base> implements Observer<T>   {

    private  Boolean isShowLoding =true;
    private BaseView baseView;
    private int requestcode;

    public  MyObserver(BaseView baseView, int requestcode) {
        this.baseView = baseView;
        this.requestcode = requestcode;
    }
    public MyObserver(BaseView baseView, int requestcode,Boolean isShowLoding) {
        this.baseView = baseView;
        this.requestcode = requestcode;
        this.isShowLoding = isShowLoding;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
      //  isShowLoding ? baseView.loding(): "";
        checkNetWork();
        if(isShowLoding){
            baseView.loding();
        }
    }

    private void checkNetWork() {

    }


    @Override
    public void onError(@NonNull Throwable e) {
        
        
        // // TODO: 2018/5/25 0025  错图提示
        //baseView.error();
        if(isShowLoding)
        baseView.finishLoding();
    }

    @Override
    public void onComplete() {
        //baseView.error();
        if(isShowLoding)
        baseView.finishLoding();
    }

    @Override
    public void onNext(T t) {
        if (t.getCode()==200){
            baseView.success(requestcode,t);
        }else {
            baseView.error(t);
        }
        if(isShowLoding)
        baseView.finishLoding();
    }
}
