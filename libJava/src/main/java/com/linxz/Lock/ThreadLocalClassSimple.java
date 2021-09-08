package com.linxz.Lock;

/**
 * @author Linxz
 * 创建日期：2021年09月07日 10:57 上午
 * version：
 * 描述：
 */
public class ThreadLocalClassSimple {

    private static ThreadLocal<Integer> age = new ThreadLocal<>();
    private static ThreadLocal<Integer> height = new ThreadLocal<>();


    public static void main(String[] args) {
        age.set(10);
        height.set(100);
        System.out.println("age:"+age.get());
    }

    private static class Person{
        public int age;
    }

} 