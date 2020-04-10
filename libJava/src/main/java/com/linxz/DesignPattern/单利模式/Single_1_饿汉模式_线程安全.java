package com.linxz.DesignPattern.单利模式;

/**
 * 没法延时加载
 * */
public class Single_1_饿汉模式_线程安全 {

    public static final Single_1_饿汉模式_线程安全 mInstance=new Single_1_饿汉模式_线程安全();

    private Single_1_饿汉模式_线程安全(){}

    public static Single_1_饿汉模式_线程安全 getInstance(){
        return mInstance;
    }

    public String getPatternName(){
        System.out.println("单利设计模式--饿汉模式");
        return "单利设计模式--饿汉模式";
    }
}