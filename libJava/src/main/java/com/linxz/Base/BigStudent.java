package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2021年02月27日 12:00 AM
 * version：
 * 描述：
 */
class BigStudent extends Student{

    @Override
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        BigStudent bigStudent=new BigStudent();
        bigStudent.setAge(10);
        System.out.println(bigStudent.getAge());
    }
}
