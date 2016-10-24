package com.qiyei.weather;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by qiyei2015 on 2016/10/14.
 * 1273482124@qq.com
 */

public class WeatherApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
