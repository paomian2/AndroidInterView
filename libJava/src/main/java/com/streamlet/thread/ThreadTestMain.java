package com.streamlet.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Linxz
 * 创建日期：2021年04月13日 11:56 AM
 * version：
 * 描述：
 */
class ThreadTestMain {


    public static void main(String[] args) {


//        MyThread2 myThread1=new MyThread2("aa");
//        MyThread2 myThread2=new MyThread2("bb");
//        MyThread2 myThread3=new MyThread2("cc");
//        MyThread2 myThread4=new MyThread2("dd");
//        MyThread2 myThread5=new MyThread2("ee");
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        myThread5.start();


        MyThreadRunnable mt=new MyThreadRunnable();
        Thread thread1=new Thread(mt);
        Thread thread2=new Thread(mt);
        Thread thread3=new Thread(mt);
        Thread thread4=new Thread(mt);
        Thread thread5=new Thread(mt);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static class MyThreadRunnable implements Runnable{
        private int ticket=5;

        @Override
        public void run() {
            while (ticket>0){
                ticket--;
                System.out.println("卖了一张票，还剩"+ticket+"张");
            }
        }
    }


    public static class MyThread2 extends Thread{
        private int ticket=5;
        private String name;
        public MyThread2(String name){
            this.name=name;
        }
        @Override
        public void run() {
            while (ticket>0){
                ticket--;
                System.out.println(name+"卖了一张票，还剩"+ticket+"张");

            }
        }
    }





    public static void threadPool(){
        Executor executor = new ThreadPoolExecutor(0 /* corePoolSize */,
                Integer.MAX_VALUE /* maximumPoolSize */, 60L /* keepAliveTime */,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory());
    }
}
