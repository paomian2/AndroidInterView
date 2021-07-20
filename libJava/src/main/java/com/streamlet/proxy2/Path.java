package com.streamlet.proxy2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 11:45 PM
 * version：
 * 描述：
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface Path {
    String value() default "";
}
