package com.linxz.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 11:56
 * version：v4.5.4
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value() default "unknown";
}
