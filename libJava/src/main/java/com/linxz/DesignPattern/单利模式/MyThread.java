package com.linxz.DesignPattern.单利模式;

public class MyThread extends Thread{

    //1、单例类只能有一个实例。
    //2、单例类必须自己创建自己的唯一实例。
    //3、单例类必须给所有其他对象提供这一实例。
    //单利六种写法：饿汉/懒汉/懒汉线程安全/DCL/静态内部类/枚举


    //查看hasCode是否一直来判断是否是同一个对象


    @Override
    public void run() {
        super.run();
        //System.out.println(Single_0_非单利.getInstance().hashCode());
        //System.out.println(Single_1_饿汉模式_线程安全.getInstance().hashCode());
        // System.out.println(Single_2_懒汉模式_线程不安全.getInstance().hashCode());
        //System.out.println(Single_3_懒汉模式_synchronized_线程安全.getInstance().hashCode());
        //System.out.println(Single_3_懒汉模式_synchronized_线程安全.getInstance2().hashCode());

        //System.out.println(Single_4_双重锁模式_线程不安全.getInstance().hashCode());
        //System.out.println(Single_5_双重锁模式_volatile_线程安全.getInstance().hashCode());

        // System.out.println(Single_6_静态内部类模式_线程安全.getInstance().hashCode());
        System.out.println(Single_7_枚举模式_线程安全.getInstance().hashCode());
    }


    public static void main(String[] args) {
        MyThread[] mts=new MyThread[2000];
        for (int i=0;i<mts.length;i++){
            mts[i]=new MyThread();
            mts[i].start();
        }
        //懒汉模式-hashCode不唯一，所以单利失效了
    }
}