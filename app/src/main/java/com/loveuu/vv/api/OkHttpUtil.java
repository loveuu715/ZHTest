package com.loveuu.vv.api;

import com.loveuu.vv.BaseApplication;
import com.loveuu.vv.mvp.activity.RequestLogInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by VV on 2016/9/22.
 */

public class OkHttpUtil {

    private static OkHttpClient sOkHttpClient;

    //设置缓存目录
    private static File cacheDirectory = new File(BaseApplication.getApplication().getApplicationContext().getCacheDir().getAbsolutePath(), "ZHCache");
    private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);

    //设缓存有效期为1天
    protected static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;

    //查询缓存的Cache-Control设置，使用缓存
    protected static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    //查询网络的Cache-Control设置。不使用缓存
    protected static final String CACHE_CONTROL_NETWORK = "max-age=0";

    // 请求log拦截器  打印所有的log
    private static RequestLogInterceptor logInterceptor = new RequestLogInterceptor();

    /**
     * 拦截器  给所有的请求添加消息头
     */
    private static Interceptor sHeaderInterceptor = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
//                    .addHeader(HEADER_X_HB_Client_Type, FROM_ANDROID)
                    .build();
            return chain.proceed(request);
        }
    };


    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public static OkHttpClient getClient() {
        if (null == sOkHttpClient) {
            sOkHttpClient = new OkHttpClient.Builder()
                    //.addInterceptor(new MyIntercepter())
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
//                    .addInterceptor(sHeaderInterceptor)//所有请求头拦截器
                    .addInterceptor(logInterceptor)//TODO 设置请求日志拦截器,release取消掉
                    .connectTimeout(15, TimeUnit.SECONDS)
//                    .writeTimeout(30, TimeUnit.SECONDS)
//                    .readTimeout(30, TimeUnit.SECONDS)
                    .cache(cache)
                    .build();
        }
        return sOkHttpClient;
    }
}
