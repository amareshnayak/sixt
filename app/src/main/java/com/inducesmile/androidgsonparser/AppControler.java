package com.inducesmile.androidgsonparser;

/**
 * Created by amaresh on 30/08/17.
 */

import android.app.Application;
import android.content.Context;

public class AppControler extends Application {
    private static AppControler mInstance;
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        this.setAppContext(getApplicationContext());
    }

    public static AppControler getInstance(){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }
}