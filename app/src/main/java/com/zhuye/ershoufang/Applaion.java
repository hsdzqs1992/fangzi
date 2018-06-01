package com.zhuye.ershoufang;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.support.multidex.MultiDex;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.zhuye.ershoufang.receiver.NetworkChangeReceiver;
import com.zhuye.ershoufang.utils.SharedPreferencesUtil;

import io.rong.imkit.RongIM;
import io.rong.push.RongPushClient;

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
//        微信支付app信息
//        Appid:wxcc535962638755d5
//        Appscret：98f1bc28a37829bc09491603096efca5
//        PlatformConfig.setWeixin();
        PlatformConfig.setWeixin("wxcc535962638755d5", "98f1bc28a37829bc09491603096efca5");
        PlatformConfig.setQQZone("1106731617", "3nrVbGMOblDDfhJN");
        umShareAPI =  UMShareAPI.get(this);
        MultiDex.install(this);
        //  异常的处理
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.setCrashHandler(getApplicationContext());
        Stetho.initializeWithDefaults(this);
        SDKInitializer.initialize(getApplicationContext());
        //

        //regeist();
//        App Key k51hidwqkco5b
//        App Secret x5hqBniaFvt0

        RongIM.init(this,"c9kqb3rdcov6j");

        RongPushClient.init(this, "c9kqb3rdcov6j");
       // RongCloudEvent.init(this);

      //  RongIM.getInstance()


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


    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }


}
