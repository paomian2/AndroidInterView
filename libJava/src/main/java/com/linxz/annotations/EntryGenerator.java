package com.linxz.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2021年02月27日 12:35 AM
 * version：
 * 描述：
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface EntryGenerator {
    String packageName();
    Class<?> entryTemplate();
}
