package com.linxz.androidinterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.linxz.androidinterview.work.WorkRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView iv=findViewById(R.id.iv);
        iv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int width=iv.getWidth();
                int height=iv.getHeight();
                Log.d("TAG","width:"+width);
                Log.d("TAG","height:"+height);
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
    }
}
