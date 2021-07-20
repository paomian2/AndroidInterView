package com.tencent_class.泛型;

import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年03月11日 10:54 PM
 * version：
 * 描述：
 *
 *  虚拟机 运行期(检测) 报异常
 */
class 泛型类 {

    //泛型方法
    public <T> T test1(T t){
        return t;
    }
    //不是泛型方法
    public void test2(List<String> list){}
    //不是泛型方法
    public void test3(List<?> list){}

    //泛型类
    public static class Box<T>{
        //也不是泛型方法
        public void test5(T t){}
    }




}

interface Generics<T>{}

class Generics2 implements Generics{}

class Generics3 implements Generics<String>{}

//class Generics4 implements Generics<T>{} 不能这么写

//这种写法，实例化对象的时候指定T
class Generics4<T> implements Generics<T>{}


class 通配符{
    public static void main(String[] args) {
    }

    //PESC  PESC  = producer-extens , consumer -super.

    //? extends Number   PE方式，只可以从list拿数据，不允许添加数据
    public static double sumOfList(List<? extends Number> list){
        //使用? extends Number，导致list只能读，不能写  list.add(1);报错
        return 0;
    }

    //SC模式，只允许添加操作，不允许读取操作
    public static void addNumber(List<? super Number> list){
        //Integer tmp=list.get(0);会报错
        list.add(1);
    }


    //不受限制
    public static void printList(List<?> list){
        list.add(null);
        list.get(0);
        //副作用，带有T的参数都不能使用，比如 list.add("");
        //导致了类型退化
    }
}

//Java泛型是一种伪泛型，因为虚拟器不支持泛型(字节码不是泛型了，类型擦除)，编译的时候改为不是泛型的代码。C++真正的泛型。kotlin也是伪泛型
//Java的泛型只是语法糖