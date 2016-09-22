package com.loveuu.vv.api;

import rx.Subscriber;

/**
 * Created by VV on 2016/9/22.
 */

public abstract class HttpSubscriber<T> extends Subscriber<T> {

    private Object tag;

    public HttpSubscriber(Object tag) {
        this.tag = tag;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }


    public abstract void onSuccess(T t, Object tag);

    public abstract void onError(String msg, Object tag);

    public abstract void complete();
}
