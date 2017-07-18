package com.vsossella.mvvmapp;

import android.app.Application;

import com.vsossella.mvvmapp.inject.components.AppComponent;
import com.vsossella.mvvmapp.inject.components.DaggerAppComponent;
import com.vsossella.mvvmapp.inject.modules.AppModule;
import com.vsossella.mvvmapp.inject.modules.NetworkModule;

/**
 * Created by vsossella on 26/06/17.
 */

public class MainApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .networkModule(new NetworkModule(getResources().getString(R.string.API_BASE_URL)))
                    .build();
        }
    }

    public static AppComponent getAppComponent() {
        return component;
    }
}
