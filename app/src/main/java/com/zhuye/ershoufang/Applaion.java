package com.zhuye.ershoufang;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.zhuye.ershoufang.receiver.NetworkChangeReceiver;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

/**
 * Created by Administrator on 2018/3/20 0020.
 */

public class Applaion extends Application {

    public UMShareAPI umShareAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "1b0fa0055c", true);
        SharedPreferencesUtil.init(this,"fz", Context.MODE_PRIVATE);
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106731617", "3nrVbGMOblDDfhJN");
        umShareAPI =  UMShareAPI.get(this);
        MultiDex.install(this);
        //  异常的处理
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.setCrashHandler(getApplicationContext());
        Stetho.initializeWithDefaults(this);
        //

        //regeist();
    }

    private void regeist() {
        IntentFilter filter = new IntentFilter();
        //监听wifi连接（手机与路由器之间的连接）
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        //监听互联网连通性（也就是是否已经可以上网了），当然只是指wifi网络的范畴
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        //这个是监听网络状态的，包括了wifi和移动网络。
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetworkChangeReceiver(), filter);
    }


}
