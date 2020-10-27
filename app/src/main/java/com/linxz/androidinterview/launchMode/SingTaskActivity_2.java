package com.linxz.androidinterview.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.linxz.androidinterview.R;

public class SingTaskActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SingTask","SingTaskActivity_2 onCreate");
        setContentView(R.layout.activity_sing_task_2);
        findViewById(R.id.btnSingleTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingTaskActivity_2.this,SingTaskActivityHome.class);
                intent.putExtra("userName","First456");
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SingTask","SingTaskActivity_2 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SingTask","SingTaskActivity_2 onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SingTask","SingTaskActivity_2 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SingTask","SingTaskActivity_2 onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SingTask","SingTaskActivity_2 onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SingTask","SingTaskActivity_2 onDestroy");
    }
}
