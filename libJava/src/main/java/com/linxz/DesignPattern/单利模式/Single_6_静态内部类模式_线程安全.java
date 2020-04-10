package com.linxz.DesignPattern.单利模式;

/**
 * 不使用内部类的时候，虚拟机就不会创建这个类，也就不会生成这个对象
 * static：导致对象长期存在，确保唯一性
 * final；导致对象不被改变
 *
 * */
public class Single_6_静态内部类模式_线程安全 {

    private Single_6_静态内部类模式_线程安全(){}

    /**
     * 类跟对象都使用private，确保只有Single_6_静态内部类模式类才能使用它
     * */
    private static class Hold{
        private final static Single_6_静态内部类模式_线程安全 instance=new Single_6_静态内部类模式_线程安全();
    }

    public static Single_6_静态内部类模式_线程安全 getInstance(){
        return Hold.instance;
    }
}