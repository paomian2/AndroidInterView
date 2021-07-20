package com.streamlet.generic_interface;

/**
 * @author Linxz
 * 创建日期：2021年03月03日 12:34 AM
 * version：
 * 描述：
 */
class StaticGenericTestMain {

   // private static T instance; 不能这么定义，因为对象在创建的时候才知道T，而static在对象创建之前已经执行

    public static <T> void getInstance(T t){
        System.out.println(t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        getInstance(0.00000000+"");
    }
}
