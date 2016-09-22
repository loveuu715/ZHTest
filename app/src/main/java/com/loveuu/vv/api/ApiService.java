package com.loveuu.vv.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by VV on 2016/9/22.
 */

public interface ApiService {
    //Index/getCarouselImg?token=f201ccd908560ea9fe287e3d08379863&secret_key=rA21VeE8347bScsuIDNq&adcode=440300
    @GET("Index/getCarouselImg")
    <T> Observable<T> getBannerList(@Query("token") String token, @Query("secret_key") String secret_key, @Query("adcode") String adcode);
}
