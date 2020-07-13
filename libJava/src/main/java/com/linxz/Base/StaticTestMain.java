package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2020年05月07日 16:00
 * version：v4.5.4
 * 描述：
 */
public class StaticTestMain {

    public static int i=1;

    static {
        System.out.println("这是一个静态方法块");
    }

    {
        System.out.println("这是一个方法块");
    }

    public StaticTestMain(){
        System.out.println("这是这个构造方法");
    }

    public void sayHello(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        StaticTestMain testMain=new StaticTestMain();
        testMain.sayHello();
    }
}
