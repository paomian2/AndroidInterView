package com.linxz.androidinterview.leakcanary;


import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author Linxz
 * 创建日期：2021年04月06日 1:09 AM
 * version：
 * 描述：
 */
class LeakCanaryManager {

    private Application application;
    public void init(){
        application.getApplicationContext();
        LeakCanary.install(application);
    }


}
