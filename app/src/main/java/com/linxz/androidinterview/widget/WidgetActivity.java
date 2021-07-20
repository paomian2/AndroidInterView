package com.linxz.androidinterview.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.linxz.androidinterview.R;

import java.util.concurrent.locks.Lock;

public class WidgetActivity extends AppCompatActivity {

    private MeasureSpecTestView measureSpecView;
    private TextView tvMeasureSpec;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        measureSpecView=findViewById(R.id.measureSpecView);
        tvMeasureSpec=findViewById(R.id.tvMeasureSpec);


    }


    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("MeasureSpecTestView","获取模式值："+measureSpecView.getMeasureSpec());
                tvMeasureSpec.setText("模式："+measureSpecView.getMeasureSpec());
            }
        },4000);

    }
}
