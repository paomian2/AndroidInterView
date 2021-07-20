package com.linxz.androidinterview.launchMode.child;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.linxz.androidinterview.R;

public class A_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_);
        Log.d("singleTask","A_onCreate");
        String params=getIntent().getStringExtra("params");
        Log.d("singleTask",""+params);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String params=intent.getStringExtra("params");
        Log.d("singleTask","A_onNewIntent");
        Log.d("singleTask",params);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("singleTask","A_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("singleTask","A_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("singleTask","A_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("singleTask","A_onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("singleTask","A_onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("singleTask","A_onDestroy");
    }

    public void AActivityClick(View view){
        Intent intent=new Intent(this,B_Activity.class);
        startActivity(intent);
    }
}
