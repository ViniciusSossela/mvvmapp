package com.vsossella.mvvmapp.api;

/**
 * Created by vsossella on 26/06/17.
 */

public interface CallbackListener<T,E> {

    void onResponseSuccess(T responseSuccess);
    void onResponseFailed(E responseFailed);

}
