package com.linxz.androidinterview.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 10:52
 * version：v4.5.4
 * 描述：StudyAnnotation只有一个RetentionPolicy，有多个ElementType
 *      ElementType:表明了StudyAnnotation的用途(可有可无)。例如，若一个 Annotation 对象是 METHOD 类型，则该 Annotation 只能用来修饰方法。
 *
 *      RetentionPolicy:表明Annotation的策略(必须要有)。
 *
 *
 * a) 若 Annotation 的类型为 SOURCE，则意味着：Annotation 仅存在于编译器处理期间，编译器处理完之后，该 Annotation 就没用了(类似与工具类)。 例如，" @Override" 标志就是一个 Annotation。当它修饰一个方法的时候，就意味着该方法覆盖父类的方法；并且在编译期间会进行语法检查！编译器处理完后，"@Override" 就没有任何作用了。
 * b) 若 Annotation 的类型为 CLASS，则意味着：编译器将 Annotation 存储于类对应的 .class 文件中(新建.class文件)，它是 Annotation 的默认行为。
 * c) 若 Annotation 的类型为 RUNTIME，则意味着：编译器将 Annotation 存储于class文件中(在源码中生成相关代码)，并且可由JVM读入。
 *
 *
 *
 * 注解没有行为，只有数据(提供相应的数据)
 */
@Documented//可有可无；若没有定义，则 Annotation 不会出现在 javadoc 中
@Target({ElementType.TYPE,ElementType.FIELD})
                        //TYPE:类、接口（包括注释类型）或枚举声明
                        //FIELD:字段声明（包括枚举常量）
                        //METHOD:方法声明
                        //PARAMETER:参数声明
                        //CONSTRUCTOR:构造方法声明
                        //LOCAL_VARIABLE:局部变量声明
                        //ANNOTATION_TYPE:注释类型声明
                        //PACKAGE:包声明

@Retention(RetentionPolicy.RUNTIME)
                                   //SOURCE:Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有该Annotation信息了
                                  //CLASS:编译器将Annotation存储于类对应的.class文件中。默认行为
                                  //RUNTIME:编译器将Annotation存储于class文件中，并且可由JVM读入
public @interface StudyAnnotation {

}
