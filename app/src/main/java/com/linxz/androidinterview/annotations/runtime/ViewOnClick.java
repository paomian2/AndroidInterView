package com.linxz.androidinterview.annotations.runtime;

import android.view.View;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Linxz
 * 创建日期：2020年07月30日 15:40
 * version：v4.5.4
 * 描述：
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OnClickEvent(listenerType = View.OnClickListener.class,listenerSetter = "setOnClickListener",methodName="onClick")
public @interface ViewOnClick {
    int[] value();//控件ID数组
}



//textView.setOnClickListener(View.OnClickListener listener);
//    //@ViewClick({viewId1,viewId2})
//    //p
