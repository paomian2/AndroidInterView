package com.linxz.DesignPattern.单利模式;

/**
 * DCL
 * 只有初始化的时候才真正走进锁(synchronized)里面，解决了性能问题
 *
 *
 *
 * */
public class Single_5_双重锁模式_volatile_线程安全 {

    //使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前。
    private volatile static Single_5_双重锁模式_volatile_线程安全 instance;

    private Single_5_双重锁模式_volatile_线程安全(){}

    public static Single_5_双重锁模式_volatile_线程安全 getInstance(){
        //避免没必要的同步
        if (instance==null){
            //同步锁
            synchronized (Single_5_双重锁模式_volatile_线程安全.class){
                //一次初始化
                if (instance==null){
                    // success
                    // 1.分配内存空间 2.初始化对象 3.将对象指向刚分配的内存空间(分配了内存就认为instance已经初始化了)
                    // 这里面的步骤只能是：1，2，3
                    instance=new Single_5_双重锁模式_volatile_线程安全();
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