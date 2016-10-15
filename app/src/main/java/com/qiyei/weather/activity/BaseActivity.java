package com.qiyei.weather.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.qiyei.weather.util.EventBusUtil;

/**
 * Created by qiyei2015 on 2016/10/14.
 * 1273482124@qq.com
 */

public class BaseActivity extends FragmentActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        EventBusUtil.registerEventBus(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unRegisterEventBus(this);
    }

    @Override
    public void onClick(View view) {

    }
}
