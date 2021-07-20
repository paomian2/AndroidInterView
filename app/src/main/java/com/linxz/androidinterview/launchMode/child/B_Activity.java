package com.linxz.androidinterview.launchMode.child;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.linxz.androidinterview.R;

public class B_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_);
        Log.d("singleTask","B_onCreate");
        String params=getIntent().getStringExtra("params");
        Log.d("singleTask",""+params);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String params=intent.getStringExtra("params");
        Log.d("singleTask","B_onNewIntent");
        Log.d("singleTask",params);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("singleTask","B_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("singleTask","B_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("singleTask","B_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("singleTask","B_onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("singleTask","B_onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("singleTask","B_onDestroy");
    }
}
