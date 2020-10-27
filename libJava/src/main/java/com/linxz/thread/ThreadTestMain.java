package com.linxz.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author Linxz
 * 创建日期：2020年08月20日 21:44
 * version：v5.0.0
 * 描述：异步初始化sdk，并且等三个都实例化之后才进入下一个步骤
 */
public class ThreadTestMain {

    public static void main(String[] args) {
        ThreadTestMain threadTestMain=new ThreadTestMain();
        long time1=System.currentTimeMillis();
        threadTestMain.init2();
        long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }

    private CountDownLatch countDownLatch=new CountDownLatch(4);

    private void init2(){
        initBDSDK();
        initUMSDK();
        initJPUSHSDK();
    }


    //异步初始化sdk，并且等三个都实例化之后才进入下一个步骤
    private void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                initBDSDK();
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                initUMSDK();
                countDownLatch.countDown();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                initJPUSHSDK();
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4.三个SDK都初始化完成后进入页面");
    }

    private void initBDSDK(){
        for (int i=0;i<5000000;i++){

        }
        System.out.println("1.initBDSDK");
    }
    private void initUMSDK(){
        for (int i=0;i<5000000;i++){

        }
        System.out.println("2.initUMSDK");
    }
    private void initJPUSHSDK(){
        for (int i=0;i<5000000;i++){

        }
        System.out.println("3.initJPUSHSDK");
    }
}
