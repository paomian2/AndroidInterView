package com.linxz.androidinterview.handler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * @author Linxz
 * 创建日期：2021年04月06日 12:14 AM
 * version：
 * 描述：
 */
class Handler2Activity extends Activity {

    private Activity activity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         activity=this;
     //   mHanlder.sendEmptyMessage(0);

        MyHandler myHandler=new MyHandler(activity);
    }


    private  class  MyHandler extends Handler{

        WeakReference<Activity> weakReference;

        public MyHandler(Activity activity){
            weakReference=new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            weakReference.get().finish();
        }
    }

    private  Handler mHandler;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
