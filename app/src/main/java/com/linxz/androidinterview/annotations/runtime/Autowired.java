package com.linxz.androidinterview.annotations.runtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2021年04月07日 4:00 PM
 * version：
 * 描述：
 */
@Target(ElementType.FIELD) //作用到全局变量上
@Retention(RetentionPolicy.RUNTIME) //运行时注解，运行到代码上的时候才执行
public @interface Autowired {
}