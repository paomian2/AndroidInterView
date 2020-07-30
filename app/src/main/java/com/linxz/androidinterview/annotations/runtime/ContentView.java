package com.linxz.androidinterview.annotations.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 13:45
 * version：v4.5.4
 * 描述：
 */
@Target(ElementType.TYPE)//注解作用在类上
@Retention(RetentionPolicy.RUNTIME) //运行时注解,运行到代码的时候才会执行
public @interface ContentView {
    int value();
}
