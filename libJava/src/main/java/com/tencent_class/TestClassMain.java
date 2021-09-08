package com.tencent_class;

/**
 * @author Linxz
 * 创建日期：2021年08月04日 5:57 PM
 * version：
 * 描述：
 */
public class TestClassMain {

    public static void main(String[] args) {
        PingNanStudent student = new PingNanStudent();
    }
}

class PingNanStudent extends Student{
    public Person2 person = new Person2("pingnan");

    PingNanStudent(){
        printStudentPerson();
    }

    public void printStudentPerson(){
        System.out.println(person);
    }

}

class Student{

    public Person2 person = new Person2("student");

    Student(){

    }

    public void printStudentPerson(){
        System.out.println();
    }
}


class Person2 {

    public Person2(String arg){
        System.out.println(arg);
    }
}