package com.linxz.DesignPattern.单利模式;

/**
 * 不足：性能差，需要排队
 * 优化：使用双重锁机制(DCL)
 *
 * */
public class Single_3_懒汉模式_synchronized_线程安全 {

    private static Single_3_懒汉模式_synchronized_线程安全 instance;

    private Single_3_懒汉模式_synchronized_线程安全(){}

    /**
     * 方法一
     * */
    public static synchronized Single_3_懒汉模式_synchronized_线程安全 getInstance(){
        if (instance==null){
            instance=new Single_3_懒汉模式_synchronized_线程安全();
        }
        return instance;
    }

    /**
     * 方法二
     * */
    public static Single_3_懒汉模式_synchronized_线程安全 getInstance2(){
        synchronized (Single_3_懒汉模式_synchronized_线程安全.class){
            if (instance==null){
                instance=new Single_3_懒汉模式_synchronized_线程安全();
            }
            return instance;
        }
    }


    public String getPatternName(){
        System.out.println("单利设计模式--懒汉线程安全模式");
        return "单利设计模式--懒汉线程安全模式";
    }

}
