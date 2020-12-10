package com.linxz.androidinterview.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * @author Linxz
 * 创建日期：2020年10月20日 15:05
 * version：
 * 描述：
 */
public class ThreadHandlerExcutor {

    private MyHandlerThread mMyHandlerThread;
    int count=1000;

    public ThreadHandlerExcutor(){
        mMyHandlerThread=new MyHandlerThread();
        mMyHandlerThread.start();
        final InnerHandler handler=new InnerHandler(mMyHandlerThread.getLooper());
        Message message=new Message();
        message.obj=count;
        handler.sendMessage(message);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //
                handler.sendMessage(new Message());
            }
        }).start();
    }

    public static class InnerHandler extends Handler{
        private InnerHandler(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("ThreadHandlerExcutor",msg.obj+"");
        }
    }


    public void test(){
        Handler mHandler=new Handler();
        //mHandler.sendEmptyMessage()
    }
}
