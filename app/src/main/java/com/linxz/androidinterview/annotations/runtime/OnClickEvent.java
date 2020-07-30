package com.linxz.androidinterview.annotations.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 16:56
 * version：v4.5.4
 * 描述：
 */
@Target(ElementType.ANNOTATION_TYPE) //声明
@Retention(RetentionPolicy.RUNTIME) //运行时注解
public @interface OnClickEvent {
    String listenerSetter();//拦截的方法名称  setOnClickListener
    Class<?> listenerType();//拦截的方法的参数类型  View.OnClickListener
    String methodName();//拦截下来的方法中的参数接口对应的方法名称 onClick(View v)
}


 //        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

//    //@ViewClick({viewId1,viewId2})
//    //public void onclick(View view){}