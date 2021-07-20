package com.streamlet.proxy2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2021年03月05日 12:19 AM
 * version：
 * 描述：
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface GET {
    String value() default "";
}
