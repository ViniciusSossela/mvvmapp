package com.vsossella.mvvmapp.inject.modules;

import android.app.Application;
import android.content.Context;

import com.vsossella.mvvmapp.MainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vsossella on 26/06/17.
 */

@Module
public class AppModule {

    private final MainApplication application;

    public AppModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

}
