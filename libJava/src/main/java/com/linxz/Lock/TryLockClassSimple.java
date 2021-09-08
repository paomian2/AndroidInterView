package com.linxz.Lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author Linxz
 * 创建日期：2021年09月07日 12:49 下午
 * version：
 * 描述：
 */
public class TryLockClassSimple {

    private static Lock lock3 = new ReentrantLock();
    private static Lock lock4 = new ReentrantLock();

    private static void play1() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while (true){
            if (lock3.tryLock()){
                try {
                    System.out.println("线程"+threadName+":获得lock3锁");
                    if (lock4.tryLock()){
                        try {
                            System.out.println("线程"+threadName+":获得lock4锁");
                            break;
                        }finally {
                            lock4.unlock();
                        }
                    }
                }finally {
                    lock3.unlock();
                }
            }
            Thread.sleep(new Random().nextInt(3));//解决(活锁，一直在拿锁、释放锁，直到符合条件)
        }
    }

    private static void play2() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        while (true){
            if (lock4.tryLock()){
                try {
                    System.out.println("线程"+threadName+":获得lock4锁");
                    if (lock3.tryLock()){
                        try {
                            System.out.println("线程"+threadName+":获得lock3锁");
                            break;
                        }finally {
                            lock3.unlock();
                        }
                    }
                }finally {
                    lock4.unlock();
                }
            }
           Thread.sleep(new Random().nextInt(3));//解决(活锁，一直在拿锁、释放锁，直到符合条件)
        }
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    play1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    play2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
//很长(活锁，一直在拿锁、释放锁，直到符合条件)：解决：休眠一下
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-1:获得lock4锁
//线程Thread-0:获得lock3锁