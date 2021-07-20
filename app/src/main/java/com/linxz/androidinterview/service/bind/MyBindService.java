package com.linxz.androidinterview.service.bind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * @author Linxz
 * 创建日期：2021年04月09日 5:17 PM
 * version：
 * 描述：
 */
class MyBindService extends Service {

    private IBinder simpleBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        simpleBinder=new SimpleBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return simpleBinder;
    }

    private class SimpleBinder extends Binder {
        public MyBindService getService(){
            return MyBindService.this;
        }
    }
}
