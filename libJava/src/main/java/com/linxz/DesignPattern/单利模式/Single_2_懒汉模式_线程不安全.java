package com.linxz.DesignPattern.单利模式;

/**
 * 多线程场景会失效
 * */
public class Single_2_懒汉模式_线程不安全 {

    private static Single_2_懒汉模式_线程不安全 instance;

    private Single_2_懒汉模式_线程不安全(){

    }

    public static Single_2_懒汉模式_线程不安全 getInstance(){
        if (instance==null){
            return new Single_2_懒汉模式_线程不安全();
        }
        return instance;
    }

    public String getPatternName(){
        System.out.println("单利设计模式--懒汉模式");
        return "单利设计模式--懒汉模式";
    }


    public static void main(String[] args) {
        Thread thread=new Thread();
    }

}