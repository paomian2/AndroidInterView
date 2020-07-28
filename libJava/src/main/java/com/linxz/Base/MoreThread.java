package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2020年07月27日 19:23
 * version：v4.5.4
 * 描述：
 */

public class MoreThread {

    //多线程题，两个线程轮流打印1。。。100和-1.。。-100，实现1，-1, 2，-2。。。

    public static void main(String[] args) {
        Object ob = new Object();
        new Thread(new MoreThread().new ThreadA(ob)).start();
        new Thread(new MoreThread().new ThreadB(ob)).start();
    }
    class ThreadA implements Runnable{
        private Object object=null;
        public ThreadA(Object o){
            this.object = o;
        }
        @Override
        public void run() {
            synchronized (this.object){
                for (int i=1;i<=100;i++){
                    System.out.println(i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class ThreadB implements Runnable{
        private Object object=null;
        public ThreadB(Object o){
            this.object = o;
        }
        @Override
        public void run() {
            synchronized (object){
                for (int i=-1;i>=-100;i--){
                    System.out.println(i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

