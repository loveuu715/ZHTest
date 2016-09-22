package com.loveuu.vv.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by VV on 2016/9/22.
 */

public class RetrofitUtil {

    // 请求公共部分
    private static final String BASE_URL = "http://test.hiweixiao.com/Linker/";

    private static Retrofit sRetrofit;

    public static Retrofit getRetrofit(){
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .client(OkHttpUtil.getClient())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())//使用Gson装换工厂类
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//回调使用RxJava工厂类
                    .build();
        }
        return sRetrofit;
    }

}
