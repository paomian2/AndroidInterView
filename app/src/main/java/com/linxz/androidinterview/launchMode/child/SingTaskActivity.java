package com.linxz.androidinterview.launchMode.child;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.linxz.androidinterview.R;

public class SingTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_task);
        Log.d("singleTask","SingleTask_onCreate");
        String params=getIntent().getStringExtra("params");
        Log.d("singleTask",params);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String params=intent.getStringExtra("params");
        Log.d("singleTask","SingleTask_onNewIntent");
        Log.d("singleTask",params);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("singleTask","SingleTask_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("singleTask","SingleTask_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("singleTask","SingleTask_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("singleTask","SingleTask_onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("singleTask","SingleTask_onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("singleTask","SingleTask_onDestroy");
    }

    public void singleTaskActivityClick(View view){
        Intent intent=new Intent(this,A_Activity.class);
        startActivity(intent);
    }
}
