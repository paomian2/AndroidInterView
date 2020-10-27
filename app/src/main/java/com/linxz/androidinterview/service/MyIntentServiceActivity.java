package com.linxz.androidinterview.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.linxz.androidinterview.R;

public class MyIntentServiceActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent_service);
        progressBar=findViewById(R.id.progress);
        tvStatus=findViewById(R.id.tvStatus);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        tvStatus.setText("线程状态：未运行");

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.linxz.androidinterview.downLoad");
        localBroadcastManager.registerReceiver(myBroadcastReceiver,intentFilter);

        findViewById(R.id.btnDownLoad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyIntentServiceActivity.this, MyIntentService.class);
                startService(intent);
            }
        });
    }


    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.linxz.androidinterview.downLoad".equals(intent.getAction())){
                int progress=intent.getIntExtra("progress",0);
                String status=intent.getStringExtra("status");
                progressBar.setProgress(progress);
                tvStatus.setText(status);
            }
        }
    }
}
