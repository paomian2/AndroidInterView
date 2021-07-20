package com.linxz.annotations;

import java.lang.reflect.Method;

/**
 * @author Linxz
 * 创建日期：2021年02月27日 12:11 AM
 * version：
 * 描述：
 */
class SumTestMain {

    public static void main(String[] args) {
        Method[] methods=SumTestMain.class.getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Number.class)){
                Number number=method.getAnnotation(Number.class);
                int[] values=number.value();
                int temp=0;
                for (int value : values) {
                    temp = temp + value;
                }
                System.out.println(temp);
            }
        }

       // SumTestMain sumTestMain=new SumTestMain();
       // sumTestMain.sumFetch();
    }

    @Number(value = {3,4})
    public void sum(){

    }

    public void sumFetch(){
        System.out.println(7);
    }
}
