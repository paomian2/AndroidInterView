package com.linxz.classLoader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Linxz
 * 创建日期：2021年01月10日 23:30
 * version：
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GET {
    String value() default "unknown";
}
