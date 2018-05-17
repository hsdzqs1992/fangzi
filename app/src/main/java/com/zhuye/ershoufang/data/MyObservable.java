package com.zhuye.ershoufang.data;

import com.zhuye.ershoufang.bean.Base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/3/27 0027.
 */

public  abstract class MyObservable<T extends Base> extends Observable {
//    @Override
//    protected void subscribeActual(Observer observer) {
//
//    }
    public MyObservable swichThread(){
        this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        return this;
    }

    // 多个操作都完成时 可以
    public MyObservable xuhou(){
       // this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        //this.compose()
        return this;
    }


}
