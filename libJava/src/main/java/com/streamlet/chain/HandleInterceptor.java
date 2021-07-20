package com.streamlet.chain;

/**
 * @author Linxz
 * 创建日期：2021年07月19日 1:46 PM
 * version：
 * 描述：
 */
public interface HandleInterceptor {

    Response intercept(Chain chain) throws Exception;

    interface Chain{
        Response proceed(Request request) throws Exception;
        Request request();

    }
}
