package com.linxz.Lock;

/**
 * @author Linxz
 * 创建日期：2021年09月07日 12:37 下午
 * version
 * 描述：死锁不会报错不做事不好重现，所有找问题难度大
 */
public class 死锁 {


    private static Object lock3 = new Object();
    private static Object lock4 = new Object();

    private static void play1() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (lock3){
            System.out.println("线程"+threadName+":获得lock3锁");
            Thread.sleep(3000);
            synchronized (lock4){
                System.out.println("线程"+threadName+":获得lock4锁");
            }
        }
    }

    private static void play2() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        synchronized (lock4){
            System.out.println("线程"+threadName+":获得lock4锁");
            Thread.sleep(3000);
            synchronized (lock3){
                System.out.println("线程"+threadName+":获得lock4锁");
            }
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