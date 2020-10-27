package com.linxz.DesignPattern.单利模式;

/**
 * DCL
 * 只有初始化的时候才真正走进锁(synchronized)里面，解决了性能问题
 *
 * 但是也是线性不安全，主要是初始化的位置
 *
 * 为什么加单锁的时候(Single_3_懒汉模式_synchronized_线程安全)是线程安全的？因为它直接将方法锁住了
 *    单锁的情况下：先加锁再判断空，而这里先判空，再加锁，再判空，第一个判空的位置可能会返回一个认为instance不为空但是实际上没有正常初始化完成的对象
 *
 * */
public class Single_4_双重锁模式_线程不安全 {

    private static Single_4_双重锁模式_线程不安全 instance;

    private Single_4_双重锁模式_线程不安全(){}

    public static Single_4_双重锁模式_线程不安全 getInstance(){
        //避免没必要的同步
        if (instance==null){
            //同步锁
            synchronized (Single_4_双重锁模式_线程不安全.class){
                //一次初始化
                if (instance==null){
                    //error
                    // 1.分配内存空间 2.初始化对象 3.将对象指向刚分配的内存空间(分配了内存就认为instance已经初始化了)
                    // 这里面的步骤可能会是：1，3，2，从而导致线程不安全。
                    // 这时候的流程可能为：线程A：分配内存空间--> 将对象指向刚分配的内存空间(这时候instance已经不为null了，但是实际上还没有真正初始化完成)
                    //                  线程B进入方法，此时instance不为null，直接返回一个未真正初始化的instance
                    instance=new Single_4_双重锁模式_线程不安全();
                }
            }
        }
        return instance;
    }



    public String getPatternName(){
        System.out.println("单利设计模式--双重锁(DCL)模式");
        return "单利设计模式--双重锁(DCL)模式";
    }

}