package com.zhuye.ershoufang;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
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
    }

}
