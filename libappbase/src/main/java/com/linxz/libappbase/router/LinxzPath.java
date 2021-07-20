package com.linxz.libappbase.router;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2021年04月19日 12:23 PM
 * version：
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface LinxzPath {
    String value() default "";
}
