package com.linxz.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 11:58
 * version：v4.5.4
 * 描述：
 */
public class AnnationsTestMain {


    public static void main(String[] args) {
        try {
            Method mSomebody = Person.class.getMethod("someBody", String.class);
           // mSomebody.invoke(person, "lily");
            iteratorAnnotations(mSomebody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iteratorAnnotations(Method method) {

        // 判断 somebody() 方法是否包含MyAnnotation注解
        if(method.isAnnotationPresent(MyAnnotation.class)){
            // 获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for (String str:values)
                System.out.printf(str+", ");
            System.out.println();
        }

        // 获取方法上的所有注解，并打印出来
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }


    public static class Person{

        @MyAnnotation(value = {"张飞","刘备"})
        public void someBody(String name){
            System.out.println(name);
        }
    }
}
