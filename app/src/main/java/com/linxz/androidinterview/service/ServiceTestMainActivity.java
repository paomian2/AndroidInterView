package com.linxz.androidinterview.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.linxz.androidinterview.R;
import com.linxz.androidinterview.work.WorkRequest;

public class ServiceTestMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_main);
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
                WorkRequest.getInstance(ServiceTestMainActivity.this).request();
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });

        findViewById(R.id.btnIntentService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceTestMainActivity.this, MyIntentServiceActivity.class);
                startActivity(intent);
            }
        });
    }


}
