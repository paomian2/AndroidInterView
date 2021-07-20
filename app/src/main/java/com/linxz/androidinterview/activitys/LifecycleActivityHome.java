package com.linxz.androidinterview.activitys;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.linxz.androidinterview.R;

/**
 * @author Linxz
 * 创建日期：2021年05月27日 3:19 PM
 * version：
 * 描述：
 */
public class LifecycleActivityHome extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lifecycle);
        findViewById(R.id.btn1).setOnClickListener(v -> {
            startActivity(new Intent(LifecycleActivityHome.this,LifecycleActivityHome.class));
        });
    }
}


//常规模式下：

//创建
//2021-05-27 15:30:44.531 14521-14521/com.linxz.streamlet D/BaseActivity: onCreate()
//2021-05-27 15:30:44.570 14521-14521/com.linxz.streamlet D/BaseActivity: onStart()
//2021-05-27 15:30:44.572 14521-14521/com.linxz.streamlet D/BaseActivity: onResume()

//熄屏
//2021-05-27 15:31:13.341 14521-14521/com.linxz.streamlet D/BaseActivity: onPause()
//2021-05-27 15:31:13.395 14521-14521/com.linxz.streamlet D/BaseActivity: onStop()

//亮屏
//2021-05-27 15:31:32.042 14521-14521/com.linxz.streamlet D/BaseActivity: onRestart()
//2021-05-27 15:31:32.045 14521-14521/com.linxz.streamlet D/BaseActivity: onStart()
//2021-05-27 15:31:32.047 14521-14521/com.linxz.streamlet D/BaseActivity: onResume()

//跳转页面
//2021-05-27 15:32:01.601 14521-14521/com.linxz.streamlet D/BaseActivity: onPause()
//2021-05-27 15:32:01.621 14521-14521/com.linxz.streamlet D/BaseActivity: onCreate()
//2021-05-27 15:32:01.650 14521-14521/com.linxz.streamlet D/BaseActivity: onStart()
//2021-05-27 15:32:01.652 14521-14521/com.linxz.streamlet D/BaseActivity: onResume()
//2021-05-27 15:32:02.070 14521-14521/com.linxz.streamlet D/BaseActivity: onStop()


//返回
//2021-05-27 15:32:17.187 14521-14521/com.linxz.streamlet D/BaseActivity: onPause()
//2021-05-27 15:32:17.207 14521-14521/com.linxz.streamlet D/BaseActivity: onRestart()
//2021-05-27 15:32:17.216 14521-14521/com.linxz.streamlet D/BaseActivity: onStart()
//2021-05-27 15:32:17.220 14521-14521/com.linxz.streamlet D/BaseActivity: onResume()
//2021-05-27 15:32:17.639 14521-14521/com.linxz.streamlet D/BaseActivity: onStop()
//2021-05-27 15:32:17.642 14521-14521/com.linxz.streamlet D/BaseActivity: onDestroy()