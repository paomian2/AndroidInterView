package com.streamlet.proxy2;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 11:23 PM
 * version：
 * 描述：
 */
public interface MyApiStore {
    void login();

    @GET("user/login")
    void register(@Path("name") String name,@Path("pwd") String pwd);
    //login?name=lin123&pwd=123456
}
