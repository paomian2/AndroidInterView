package com.linxz.androidinterview.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.linxz.androidinterview.MainActivity;
import com.linxz.androidinterview.R;
import com.linxz.androidinterview.launchMode.child.SingTaskActivity;
import com.linxz.androidinterview.launchMode.child.SingleTopActivity_A;

public class LaunchModeTestMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode_test_main);

        findViewById(R.id.btnSingleTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(LaunchModeTestMainActivity.this,SingleTopActivity.class);
//                intent.putExtra("userName","First123");
//                startActivity(intent);
//
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent=new Intent(LaunchModeTestMainActivity.this,SingleTopActivity.class);
//                        intent.putExtra("userName","Last456");
//                        startActivity(intent);
//                    }
//                }, 8000);
                Intent intent=new Intent(LaunchModeTestMainActivity.this, SingleTopActivity_A.class);
                intent.putExtra("params","MainActivityParams");
                startActivity(intent);
            }
        });

        findViewById(R.id.btnSingleTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(LaunchModeTestMainActivity.this,SingTaskActivityHome.class);
//                intent.putExtra("userName","First123");
//                startActivity(intent);
                Intent intent=new Intent(LaunchModeTestMainActivity.this, SingTaskActivity.class);
                intent.putExtra("params","MainActivityParams");
                startActivity(intent);
            }
        });

        findViewById(R.id.btnSingleInstance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LaunchModeTestMainActivity.this,SingInstanceActivity_1.class);
                startActivity(intent);
            }
        });
    }
}
