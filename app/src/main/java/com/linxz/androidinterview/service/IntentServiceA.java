package com.linxz.androidinterview.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author Linxz
 * 创建日期：2020年07月27日 16:53
 * version：v4.5.4
 * 描述：
 */
public class IntentServiceA extends IntentService {
    private final static String TAG="TAGA";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param : name Used to name the worker thread, important only for debugging.
     */

    public IntentServiceA() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }


    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(TAG, "onStart: ");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return super.onBind(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntentA: " + Thread.currentThread().getName()+":"+Thread.currentThread().getId());
        Log.d(TAG, "是否主线程A"+Thread.currentThread().equals(Looper.getMainLooper().getThread()));


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
