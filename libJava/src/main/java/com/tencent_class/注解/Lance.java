package com.tencent_class.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2021年03月12日 12:26 AM
 * version：
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Lance {

    int value() default 0;

    //元注解，注解上的注解

    //@Target() 注解作用在类，还是方法，成员变量上，还是方法参数上.没指明就都可以
    //@Retention() 保留级别 SOURCE保留源码,编译了之后就被抹除了(编译后的class没有了这个注解)  APT处理
    //                     CLASS
    //                     RUNTIME



    //枚举：实际上每个类型都是一个对象。对象的字节：12字节对象头+成员字节+8字对齐.所有枚举很占用内存空间
    //使用常量来代替枚举，但是不希望用户随便传，使用注解来控制(如：androix中的@IntDef


    //字节码增强：在字节码中写代码
}
