package com.linxz.androidinterview.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * @author Linxz
 * 创建日期：2020年10月20日 09:06
 * version：
 * 描述：
 */
public class MyIntentService extends IntentService {
    private final static String TAG="MyIntentService";
    private int count;
    private LocalBroadcastManager mLocalBroadcastManager;

    /**

     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param : name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {
        super("MyIntentService");
        mLocalBroadcastManager=LocalBroadcastManager.getInstance(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "是否主线程"+Thread.currentThread().equals(Looper.getMainLooper().getThread()));
        try {
            boolean isRunning = true;
            Thread.sleep(1000);
             while (isRunning){
                 count++;
                 if (count>=100){
                     isRunning =false;
                 }
                 Thread.sleep(1000);
                 setThreadStatus("线程运行中...",count);
             }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setThreadStatus(String status,int progress){
        Intent intent=new Intent();
        intent.setAction("com.linxz.androidinterview.downLoad");
        intent.putExtra("status", status);
        intent.putExtra("progress", progress);
        mLocalBroadcastManager.sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        setThreadStatus("线程结束",count);
    }
}
