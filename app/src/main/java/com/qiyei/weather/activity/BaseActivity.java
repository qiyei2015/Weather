package com.qiyei.weather.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qiyei.weather.util.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by qiyei2015 on 2016/10/14.
 * 1273482124@qq.com
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//去掉标题栏
        EventBusUtil.registerEventBus(this);//注册EventBus

        initData();
        initView();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unRegisterEventBus(this);
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * EventBus 退出应用
     * @param event
     */
    @Subscribe
    public void onEventMainThread(Object event) {

    }

    /**
     * 初始化数据
     */
    protected void initData(){

    }

    /**
     * 初始化View
     */
    protected void initView(){

    }

    /**
     * 初始化监听器
     */
    protected void initListener(){

    }

}
