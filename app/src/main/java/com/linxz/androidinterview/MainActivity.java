package com.linxz.androidinterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.linxz.androidinterview.work.WorkRequest;

import java.util.HashMap;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG1", "MainActivity");
        final ImageView iv = findViewById(R.id.iv);
        iv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                int width = iv.getWidth();
                int height = iv.getHeight();
                Log.d("TAG", "width:" + width);
                Log.d("TAG", "height:" + height);
                return true;
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkRequest.getInstance(MainActivity.this).request();
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });

        findViewById(R.id.btnAuthLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = "{\n" +
                        "  \"launcherUser\": \"黑金刚\",\n" +
                        "  \"userName\": \"访问成功\",\n" +
                        "  \"token\": \"NoJSFFlMKbqpdhpMxxmhO109Lhl3e2Kj\",\n" +
                        "  \"serviceModule\": \"1001\",\n" +
                        "  \"biddingNumber\": \"WXjj20200720154518364173\",\n" +
                        "  \"isHJG\": true\n" +
                        "}\n" +
                        "\n";
                Intent intent = new Intent(Intent.ACTION_MAIN);
                ComponentName componentName = new ComponentName("com.afor.formaintenance", "com.afor.formaintenance.activity.LaunchActivity");
                intent.setComponent(componentName);
                intent.putExtra("openParams", json);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

//        Integer a=1;
//        a.hashCode();
//
//        Double d=1D;
//        d.hashCode();
       // Hashtable
       // HashMap

}
