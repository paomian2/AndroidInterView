package com.linxz.Lock;

/**
 * @author Linxz
 * 创建日期：2021年09月07日 9:00 上午
 * version：
 * 描述：https://www.cnblogs.com/43726581Gavin/p/9066080.html
 * - java 的所有变量都存储在主内存中
 * - 每个线程有自己独的工作内存，保存了该线程使用到的变量副本，是对主内存中变量的一份拷贝
 * - 每个线程不能访问其他线程的工作内存，线程间变量传递需要通过主内存来完成
 * - 每个线程不能直接操作主存，只能把主存的内容拷贝到本地内存后再做操作（这是线程不安全的本质），然后写回主存
 * volatile
 * 这种方式可以保证每次取数直接从主存取
 * 它只能保证内存的可见性，无法保证原子性
 * 它不需要加锁，比 synchronized 更轻量级，不会阻塞线程
 */
public class VolatileClassSimple {

    private static boolean ready;
    private static int member;

    private static class PrintThread extends Thread{
        @Override
        public void run() {
            System.out.println("PrintThread is running...");
            while (!ready);
            System.out.println("member is:"+member);
        }
    }

    public static void main(String[] args) {
        PrintThread thread = new PrintThread();
        thread.start();
        change();
    }

    public static void change(){
        while (true){
            try {
                Thread.sleep(5000);
                ready = true;
                member++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
} 