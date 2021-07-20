package com.linxz.androidinterview;

import android.util.LruCache;

import retrofit2.Retrofit;

/**
 * @author Linxz
 * 创建日期：2021年04月21日 3:00 PM
 * version：
 * 描述：
 */
class RetrofitUtil {
    public void load(){
        Retrofit retrofit=new Retrofit.Builder()
                .build();


    }
}
