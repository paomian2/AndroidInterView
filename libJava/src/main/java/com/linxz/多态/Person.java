package com.linxz.多态;

/**
 * @author Linxz
 * 创建日期：2021年04月05日 12:15 PM
 * version：
 * 描述：
 */
class Person extends Animal{

    @Override
    public void eat() {
         System.out.println("我是Person");
    }
}
