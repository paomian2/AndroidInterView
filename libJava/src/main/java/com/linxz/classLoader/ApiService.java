package com.linxz.classLoader;

/**
 * @author Linxz
 * 创建日期：2021年01月10日 23:31
 * version：
 * 描述：
 */
public interface ApiService {

    @GET("/userList")
    void getUseerList();

    @GET("/userInfo")
    void getUserInfo();
}
