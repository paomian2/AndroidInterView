package com.linxz.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Linxz
 * 创建日期：2020年08月20日 22:04
 * version：v5.0.0
 * 描述：
 */
public class ThreadPool {

    public static void main(String[] args) {
        new ThreadPool().init();
    }

    private void init(){

        //核心实现
        //public ThreadPoolExecutor(int corePoolSize,
        //        int maximumPoolSize,
        //        long keepAliveTime,
        //        TimeUnit unit,
        //        BlockingQueue<Runnable> workQueue,
        //        ThreadFactory threadFactory,
        //        RejectedExecutionHandler handler);
        Executor executor = new ThreadPoolExecutor(
                0 /* corePoolSize */,// 核心池的大小。 当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中
                Integer.MAX_VALUE /* maximumPoolSize */,//线程池最大线程数，它表示在线程池中最多能创建多少个线程；
                60L /* keepAliveTime */,//表示线程没有任务执行时最多保持多久时间会终止。
                TimeUnit.SECONDS,//参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性
                new ArrayBlockingQueue<Runnable>(5),//一个阻塞队列，提交的任务将会被放到这个队列里
                Executors.defaultThreadFactory());//线程工厂，用来创建线程，主要是为了给线程起名字，默认工厂的线程名字：pool-1-thread-3。




        //1.不限制线程数量，上一个线程执行完成。后面需要线程直接拿上一个线程再执行，不用事例化新线程
        ExecutorService service= Executors.newCachedThreadPool();
        service.submit(new Runnable() {
            @Override
            public void run() {
                 System.out.println("11111");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        //2.创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService service2=Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            service2.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   i=" + temp);
                }
            });
        }


        //3.创建一个定长线程池，支持定时及周期性任务执行。
        ExecutorService service3=Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            final long begin = System.currentTimeMillis();
            final long time = begin;
            ((ScheduledExecutorService)service3).schedule(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   i=" + temp + "   time=" + (System.currentTimeMillis() - time));
                }
            }, 5, TimeUnit.SECONDS);
        }


        //4.按顺序来执行线程任务   但是不同于单线程，这个线程池只是只能存在一个线程，这个线程死后另外一个线程会补上。
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
        //保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService service4=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            service4.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   i=" + temp);
                }
            });
        }
    }
}
