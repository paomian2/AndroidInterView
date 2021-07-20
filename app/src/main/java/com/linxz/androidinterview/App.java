package com.linxz.androidinterview;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.linxz.streamletutils.NexusUtils;

/**
 * @author Linxz
 * 创建日期：2020年06月12日 13:47
 * version：v4.5.4
 * 描述：
 */
public class App extends Application {

    public static App instance=null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        String code =  NexusUtils.nexusTestCode();
        Log.d("TAG",code);


        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(){
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

        Log.d("TAG1","fdasfasf");
        sdk1();
        sdk2();
        sdk3();
        while (true){
            if (initSDK1 && initSDK2 && initSDK3){
                break;
            }
        }
    }

    private void sdk1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //业务处理...

                initSDK1=true;
            }
        }).start();

    }
    private void sdk2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //业务处理...

                initSDK2=true;
            }
        }).start();


    }
    private void sdk3(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //业务处理...

                initSDK3=true;
            }
        }).start();

    }

    private boolean initSDK1;
    private boolean initSDK2;
    private boolean initSDK3;
}
