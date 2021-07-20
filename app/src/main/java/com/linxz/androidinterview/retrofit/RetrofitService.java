package com.linxz.androidinterview.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Linxz
 * 创建日期：2021年03月03日 11:11 PM
 * version：
 * 描述：
 */
interface RetrofitService {
    @GET
    Call<String> get();


}
