package com.linxz.androidinterview.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.linxz.androidinterview.R;

import java.lang.ref.WeakReference;

public class HandlerActivity extends AppCompatActivity {

    private TextView tvLoad;
    private SafeHandler mSafeHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        tvLoad=findViewById(R.id.tvLoad);
        mSafeHandler=new SafeHandler(this);
        tvLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            Message message=new Message();
                            message.obj="加载成功";
                            mSafeHandler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        findViewById(R.id.btnThreadHandler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new ThreadHandlerExcutor();
            }
        });
    }


    public void handleMessage(Message msg){
        String result=msg.obj+"";
        tvLoad.setText(result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSafeHandler.removeCallbacksAndMessages(null);
    }

    private static class SafeHandler extends Handler{

        private WeakReference<HandlerActivity> reference;

        private SafeHandler(HandlerActivity activity){
            this.reference=new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HandlerActivity activity=reference.get();
            if (activity!=null){
                activity.handleMessage(msg);
            }
        }
    }
}
