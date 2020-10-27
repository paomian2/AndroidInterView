package com.linxz.androidinterview.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.linxz.androidinterview.R;

public class SingTaskActivity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SingTask","SingTaskActivity_1 onCreate");
        setContentView(R.layout.activity_sing_task_1);
        findViewById(R.id.btnSingleTask2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingTaskActivity_1.this,SingTaskActivity_2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SingTask","SingTaskActivity_1 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SingTask","SingTaskActivity_1 onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SingTask","SingTaskActivity_1 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SingTask","SingTaskActivity_1 onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SingTask","SingTaskActivity_1 onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SingTask","SingTaskActivity_1 onDestroy");
    }
}
