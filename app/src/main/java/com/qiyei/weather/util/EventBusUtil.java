package com.qiyei.weather.util;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by qiyei2015 on 2016/10/15.
 * 1273482124@qq.com
 */

public class EventBusUtil {

    /**
     * 注册EventBus
     * @param obj
     */
    public static void registerEventBus(Object obj){
        if (!EventBus.getDefault().isRegistered(obj)){
            EventBus.getDefault().register(obj);
        }
    }

    /**
     * 解注册EventBus
     * @param obj
     */
    public static void unRegisterEventBus(Object obj){
        if (EventBus.getDefault().isRegistered(obj)){
            EventBus.getDefault().unregister(obj);
        }
    }

}
