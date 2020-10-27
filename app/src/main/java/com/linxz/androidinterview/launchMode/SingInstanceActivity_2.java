package com.linxz.androidinterview.launchMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.linxz.androidinterview.R;

public class SingInstanceActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_instance_2);
        findViewById(R.id.btnInstanece).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingInstanceActivity_2.this,SingInstanceActivity_3.class);
                startActivity(intent);
            }
        });
    }
}
