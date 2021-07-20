package com.linxz.androidinterview.retrofit.proxy;

import retrofit2.http.GET;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 1:41 AM
 * version：
 * 描述：
 */
interface BingInterface {

    @GET("/login")
    void login();
}
