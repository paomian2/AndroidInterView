package com.linxz.androidinterview.retrofit;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Linxz
 * 创建日期：2021年03月03日 11:08 PM
 * version：
 * 描述：
 */
public class Test {
    public void test() {
        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder()
//                .addHeader("token", "123")
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<String> call = retrofitService.get();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                Log.d("1111", result);


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("1111", t.toString());


            }
        });


    }
}
