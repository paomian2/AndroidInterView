package com.linxz.androidinterview.handler;

import android.os.Looper;
/**
 * @author Linxz
 * 创建日期：2020年10月20日 14:05
 * version：
 * 描述：
 */
public class MyHandlerThread extends Thread{

    private Looper mLooper;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        mLooper=Looper.myLooper();
        synchronized (this) {
            mLooper = Looper.myLooper();
            notifyAll();
        }
        Looper.loop();
    }

    public Looper getLooper(){
        synchronized (this) {
            while (isAlive() && mLooper == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return mLooper;
    }

    public void quit(){
        mLooper.quit();
    }



}
