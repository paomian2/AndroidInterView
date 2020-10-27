package com.linxz.androidinterview.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.linxz.androidinterview.R;

public class SingTaskActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SingTask","SingTaskActivityHome onCreate");
        setContentView(R.layout.activity_sing_task_home);
        findViewById(R.id.btnSingleTask1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingTaskActivityHome.this,SingTaskActivity_1.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        String userName = getIntent().getStringExtra("userName");
        Log.d("SingTask","onNewIntent userName:"+userName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SingTask","SingTaskActivityHome onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SingTask","SingTaskActivityHome onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SingTask","SingTaskActivityHome onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SingTask","SingTaskActivityHome onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SingTask","SingTaskActivityHome onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SingTask","SingTaskActivityHome onDestroy");
    }


    //2020-10-14 09:33:32.732 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onCreate
    //2020-10-14 09:33:32.762 25760-25760/com.linxz.androidinterview D/ActivityThread: add activity client record, r= ActivityRecord{e245340 token=android.os.BinderProxy@7de6ff8 {com.linxz.androidinterview/com.linxz.androidinterview.launchMode.SingTaskActivityHome}} token= android.os.BinderProxy@7de6ff8
    //2020-10-14 09:33:32.764 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onStart
    //2020-10-14 09:33:32.766 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onResume
    //2020-10-14 09:33:37.761 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onPause
    //2020-10-14 09:33:37.860 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_1 onCreate
    //2020-10-14 09:33:37.886 25760-25760/com.linxz.androidinterview D/ActivityThread: add activity client record, r= ActivityRecord{6caa15 token=android.os.BinderProxy@8a0ded {com.linxz.androidinterview/com.linxz.androidinterview.launchMode.SingTaskActivity_1}} token= android.os.BinderProxy@8a0ded
    //2020-10-14 09:33:37.888 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_1 onStart
    //2020-10-14 09:33:37.889 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_1 onResume
    //2020-10-14 09:33:38.293 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onStop
    //2020-10-14 09:33:49.376 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_1 onPause
    //2020-10-14 09:33:49.398 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_2 onCreate
    //2020-10-14 09:33:49.423 25760-25760/com.linxz.androidinterview D/ActivityThread: add activity client record, r= ActivityRecord{373b756 token=android.os.BinderProxy@87ddce {com.linxz.androidinterview/com.linxz.androidinterview.launchMode.SingTaskActivity_2}} token= android.os.BinderProxy@87ddce
    //2020-10-14 09:33:49.426 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_2 onStart
    //2020-10-14 09:33:49.428 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_2 onResume
    //2020-10-14 09:33:49.826 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_1 onStop
    //2020-10-14 09:33:52.824 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_1 onDestroy
    //2020-10-14 09:33:52.824 25760-25760/com.linxz.androidinterview D/ActivityThread: Remove activity client record, r= ActivityRecord{6caa15 token=android.os.BinderProxy@8a0ded {com.linxz.androidinterview/com.linxz.androidinterview.launchMode.SingTaskActivity_1}} token= android.os.BinderProxy@8a0ded
    //2020-10-14 09:33:52.836 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_2 onPause
    //2020-10-14 09:33:52.851 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onRestart
    //2020-10-14 09:33:52.852 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onStart
    //2020-10-14 09:33:52.853 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivityHome onResume
    //2020-10-14 09:33:53.266 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_2 onStop
    //2020-10-14 09:33:53.269 25760-25760/com.linxz.androidinterview D/SingTask: SingTaskActivity_2 onDestroy
    //2020-10-14 09:33:53.269 25760-25760/com.linxz.androidinterview D/ActivityThread: Remove activity client record, r= ActivityRecord{373b756 token=android.os.BinderProxy@87ddce {com.linxz.androidinterview/com.linxz.androidinterview.launchMode.SingTaskActivity_2}} token= android.os.BinderProxy@87ddce


    //Home为SingTask模式
    //Home进入SingTaskActivity_1： Home(onCreate,onStart,onResume,onPause)---->>SingTaskActivity_1(onCreate,onStart,onResume)--->>>Home(onStop)
    //SingTaskActivity_1进入SingTaskActivity_2： SingTaskActivity_1(onPause)--->>>SingTaskActivity_2(onCreate,onStart,onResume)-->>>SingTaskActivity_1(onStop)
    //SingTaskActivity_2进入Home：SingTaskActivity_1(onDestroy)--->>>SingTaskActivity_2(onPause)-->>>Home(onRestart,onStart,onNewIntent,onResume)--->>>SingTaskActivity_2(onStop,onDestroy)

    //Home前面的页面(上一个页面除外)立即onDestroy，上一个页面onPause，等到Home(onRestart,onStart,onNewIntent,onResume)之后，再onDestroy
}
