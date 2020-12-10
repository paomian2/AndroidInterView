package com.linxz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        //不限制线程数量，上一个线程执行完成。后面需要线程直接拿上一个线程再执行，不用事例化新线程
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


        ExecutorService service2=Executors.newFixedThreadPool(5);

    }
}
