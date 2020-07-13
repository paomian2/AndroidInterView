package com.linxz.androidinterview.utils;

import android.os.Looper;

/**
 * @author Linxz
 * 创建日期：2020年06月15日 08:46
 * version：v4.5.4
 * 描述：
 */
public class CommonUtils {

    public static boolean isUIThread(){
        return Looper.getMainLooper()==Looper.myLooper();
    }
}
