package com.zhuye.ershoufang.data;


import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

public class HttpUtils {

    public static OkHttpClient getOkhttp(){

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);

        LogRul logRul =  new LogRul();

        logRul.open = true;

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .addInterceptor(logInterceptor)
                .addInterceptor(logRul)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        return okHttpClient;
    }

    public static Retrofit getRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new  Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(MyGsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetWorkUrl.BASE)
                .build();
        return retrofit;
    }
}
