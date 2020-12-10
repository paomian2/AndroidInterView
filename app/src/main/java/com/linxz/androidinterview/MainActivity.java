package com.linxz.androidinterview;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.linxz.androidinterview.annotations.runtime.AnnotationTestActivity;
import com.linxz.androidinterview.handler.HandlerActivity;
import com.linxz.androidinterview.kotlin.GlobalScope2;
import com.linxz.androidinterview.kotlin.GlobalScopeTestMain;
import com.linxz.androidinterview.launchMode.LaunchModeTestMainActivity;
import com.linxz.androidinterview.memory_check.MemoryLeakActivity;
import com.linxz.androidinterview.memory_check.MemoryShakeActivity;
import com.linxz.androidinterview.service.IntentServiceA;
import com.linxz.androidinterview.service.ServiceTestMainActivity;
import com.linxz.androidinterview.widget.WidgetActivity;
import com.linxz.androidinterview.work.WorkRequest;

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
                Intent intent = new Intent(MainActivity.this, IntentServiceA.class);
                startService(intent);
            }
        });

        findViewById(R.id.btnInject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AnnotationTestActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnKotlin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                GlobalScopeTestMain globalScopeTestMain=new GlobalScopeTestMain();
//                globalScopeTestMain.launchGlobalScope();
                //new GlobalScope2().main2();
                new GlobalScope2().createCoroutineTest2();
            }
        });
        findViewById(R.id.btnLaunchMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LaunchModeTestMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnAuthLogin2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                ComponentName componentName = new ComponentName("com.linxz.authapp", "com.linxz.authapp.MainActivity");
                intent.setComponent(componentName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("openParams", " {\n" +
                        "\"launcherUser\": \"HJG\",\n" +
                        "\"token\": \"422ccb90-10a0-456f-b731-f770221b9ad3\",\n" +
                        "\"userName\": \"lin123\"}");//这里Intent传值
                startActivity(intent);
            }
        });
        getUsesPermission(this);


        findViewById(R.id.btnWidget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, WidgetActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceTestMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnMemoryShake).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MemoryShakeActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnMemoryLeak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MemoryLeakActivity.class);
                startActivity(intent);
            }
        });

    }




    public static void getUsesPermission(Context context) {
        PackageManager packagema=context.getPackageManager();
        String per= Manifest.permission.READ_EXTERNAL_STORAGE;
        try {
            PermissionInfo permissionInfo = packagema.getPermissionInfo(per, 0);
            PermissionGroupInfo permissionGroupInfo = packagema.getPermissionGroupInfo(permissionInfo.group, 0);
            String label = permissionGroupInfo.loadLabel(packagema).toString();
            Log.e("label","label=="+label);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

}
