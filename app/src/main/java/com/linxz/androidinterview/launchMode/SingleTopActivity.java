package com.linxz.androidinterview.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.linxz.androidinterview.R;

public class SingleTopActivity extends AppCompatActivity {

    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletop);
        userName=getIntent().getStringExtra("userName");
        Log.d("launchMode","onCreate:"+userName);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        String userName = getIntent().getStringExtra("userName");
        Log.d("launchMode","onNewIntent userName:"+userName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("launchMode","onStart:"+userName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("launchMode","onResume:"+userName);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("launchMode","onPause:"+userName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("launchMode","onStop:"+userName);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("launchMode","onRestart:"+userName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("launchMode","onDestroy:"+userName);
    }


    //首次进入
    //2020-08-26 20:07:59.077 5562-5562/com.linxz.androidinterview D/launchMode: onCreate:First123
    //2020-08-26 20:07:59.078 5562-5562/com.linxz.androidinterview D/launchMode: onStart:First123
    //2020-08-26 20:07:59.079 5562-5562/com.linxz.androidinterview D/launchMode: onResume:First123

    //第二次进入
    //2020-08-26 20:08:02.073 5562-5562/com.linxz.androidinterview D/launchMode: onPause:First123
    //                                                               launchMode: onNewIntent userName:Last456
    //2020-08-26 20:08:02.073 5562-5562/com.linxz.androidinterview D/launchMode: onResume:First123


    //退出
    //2020-08-26 20:11:26.975 5562-5562/com.linxz.androidinterview D/launchMode: onPause:First123
    //2020-08-26 20:11:27.140 5562-5562/com.linxz.androidinterview D/launchMode: onStop:First123
    //2020-08-26 20:11:27.140 5562-5562/com.linxz.androidinterview D/launchMode: onDestroy:First123

}
