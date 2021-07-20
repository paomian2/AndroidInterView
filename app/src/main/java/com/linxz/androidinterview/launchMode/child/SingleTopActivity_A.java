package com.linxz.androidinterview.launchMode.child;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.linxz.androidinterview.R;

/**
 * @author Linxz
 * 创建日期：2021年02月16日 17:11
 * version：
 * 描述：
 */
public class SingleTopActivity_A extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_single_top_a);
        Log.d("singleTop","onCreate");
        String params=getIntent().getStringExtra("params");
        Log.d("singleTop",params);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String params=intent.getStringExtra("params");
        Log.d("singleTop","onNewIntent");
        Log.d("singleTop",params);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("singleTop","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("singleTop","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("singleTop","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("singleTop","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("singleTop","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("singleTop","onDestroy");
    }

    public void singleTopAClick(View view){
        Intent intent=new Intent(this,SingleTopActivity_A.class);
        intent.putExtra("params","SingleTopActivityParams");
        startActivity(intent);
    }
}


//2021-02-16 17:20:27.399 6535-6535/com.linxz.streamlet D/singleTop: onCreate
//2021-02-16 17:20:27.400 6535-6535/com.linxz.streamlet D/singleTop: MainActivityParams
//2021-02-16 17:20:27.404 6535-6535/com.linxz.streamlet D/singleTop: onStart
//2021-02-16 17:20:27.405 6535-6535/com.linxz.streamlet D/singleTop: onResume
//2021-02-16 17:21:08.207 6535-6535/com.linxz.streamlet D/singleTop: onPause
//2021-02-16 17:21:08.207 6535-6535/com.linxz.streamlet D/singleTop: onNewIntent
//2021-02-16 17:21:08.207 6535-6535/com.linxz.streamlet D/singleTop: SingleTopActivityParams
//2021-02-16 17:21:08.207 6535-6535/com.linxz.streamlet D/singleTop: onResume


//重新进入SingleTopActivity_A,执行onResume，onNewIntent，onResume，所以页面接收数据的时候要么在onResume里面去做，要么在onNewIntent里面进行页面刷新
//使用场景，消息推送，点击notification的时候多次进入消息详情

