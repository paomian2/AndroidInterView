package com.linxz.androidinterview.memory_check;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.linxz.androidinterview.R;

public class MemoryShakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_shake);
        findViewById(R.id.btnTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(0);
            }
        });
    }


    @SuppressLint("HandlerLeak")
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //创造内存抖动  String[]太大会闪退，手机内存不够
            for (int index=0;index<100;index++){
                String arg[]=new String[1000];
            }
            Log.d("TAG","fdasfasdfadsf");
            mHandler.sendEmptyMessageDelayed(0,500);
        }
    };
}
