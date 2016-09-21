package com.loveuu.vv;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by VV on 2016/9/21.
 * 基类应用
 */

public class BaseApplication extends Application {

    private static BaseApplication sBaseApplication;

    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        //内存泄露检测
//        LeakCanary.install(this);
        initConfiguration();
    }

    public static BaseApplication getApplication(){
        return sBaseApplication;
    }

    private void initConfiguration() {
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }
}
