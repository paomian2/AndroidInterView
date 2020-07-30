package com.linxz.androidinterview.annotations.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 14:17
 * version：v4.5.4
 * 描述：
 */
@Target(ElementType.FIELD) //作用到全局变量上
@Retention(RetentionPolicy.RUNTIME) //运行时注解，运行到代码上的时候才执行
public @interface BindView {
    int value();
}
