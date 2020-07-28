package com.linxz.DataStructure.Hash;

import java.util.HashMap;

/**
 * @author Linxz
 * 创建日期：2020年07月25日 15:57
 * version：v4.5.4
 * 描述：
 */
public class HaspCodeTestMain {

    public static void main(String[] args) {
        Student stu1=new Student(100,"zhangFei",0);
        Student stu2=new Student(100,"zhangFei",0);
        HashMap<Student,Integer> studentHashMap=new HashMap<>();
        for (int i=0;i<10000;i++){
            Student stuTemp=new Student(i,"zhangFei",0);
            studentHashMap.put(stuTemp,i);
        }
        studentHashMap.put(stu1,100);
        studentHashMap.put(stu2,99);
        System.out.println(studentHashMap.get(stu1));
    }

    public static class Student{
        public int number;
        public String name;
        public int grade;

        public Student(int number,String name,int grade){
            this.number=number;
            this.name=name;
            this.grade=grade;
        }

        @Override
        public int hashCode() {
            int B=31;
            int hash=0;
            hash=hash * B + grade;
            hash=hash * B + name.toLowerCase().hashCode();
           return hash;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this==o)
//                return true;
//            if (o==null)
//                return false;
//            if (getClass()!=o.getClass())
//                return false;
//            AbsStudent another= (AbsStudent) o;
//            return this.number==another.number &&
//                    this.name.equals(another.name) &&
//                    this.grade==another.grade;
//        }
    }
}
