package com.loveuu.vv;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.loveuu.vv.utils.LogUtil;
import com.loveuu.vv.utils.TipUtil;
import com.loveuu.vv.utils.exception.LocalExceptionHelper;

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
        sBaseApplication = this;
        //内存泄露检测
//        LeakCanary.install(this);
        initConfiguration();
    }

    private void initConfiguration() {
        LogUtil.isDebug = true;
        TipUtil.isShow = true;
        //配置程序异常退出处理
        Thread.setDefaultUncaughtExceptionHandler(new LocalExceptionHelper(this));
    }

    public static BaseApplication getApplication(){
        return sBaseApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }
}
