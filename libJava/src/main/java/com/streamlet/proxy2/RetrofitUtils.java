package com.streamlet.proxy2;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 11:23 PM
 * version：
 * 描述：
 */
class RetrofitUtils {

    public static void main(String[] args) {

        MyRetrofit retrofit=new MyRetrofit();
        MyApiStore apiStore = retrofit.create(MyApiStore.class);
        System.out.println("登录前");
        apiStore.register("lin123","123456");
        System.out.println("登录后");


    }


}

