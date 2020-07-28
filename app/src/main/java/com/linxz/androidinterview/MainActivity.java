package com.linxz.androidinterview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.linxz.androidinterview.service.IntentServiceA;
import com.linxz.androidinterview.service.IntentServiceB;
import com.linxz.androidinterview.work.WorkRequest;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG1", "MainActivity");
        final ImageView iv = findViewById(R.id.iv);
        iv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
//                int width = iv.getWidth();
//                int height = iv.getHeight();
//                Log.d("TAG", "width:" + width);
//                Log.d("TAG", "height:" + height);
                return true;
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkRequest.getInstance(MainActivity.this).request();
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });

        findViewById(R.id.btnAuthLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentServiceA.class);
                startService(intent);
            }
        });
        findViewById(R.id.btnAuthLogin2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentB = new Intent(MainActivity.this, IntentServiceB.class);
                startService(intentB);
            }
        });


       // ThreadPoolExecutor
      //  FixedThreadPool fixedThreadPool;
      //  SingleThreadExecutor singleThreadExecutor;
        //CachedThreadPool cachedThreadPool;
        //ScheduledThreadPool f;

        ScheduledThreadPoolExecutor a;

        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        ThreadPoolExecutor singleThreadExecutor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ThreadPoolExecutor scheduledThreadPool = (ThreadPoolExecutor) Executors.newScheduledThreadPool(4);
    }


}
