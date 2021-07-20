package com.linxz.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Linxz
 * 创建日期：2021年02月27日 12:10 AM
 * version：
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Number {
    int[] value() default 0;
}
