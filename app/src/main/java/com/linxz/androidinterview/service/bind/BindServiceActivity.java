package com.linxz.androidinterview.service.bind;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * @author Linxz
 * 创建日期：2021年04月09日 5:22 PM
 * version：
 * 描述：
 */
class BindServiceActivity extends Activity {

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBindService myBindService= (MyBindService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,ServiceConnection.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }


}
