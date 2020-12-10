package com.linxz.net;

import com.linxz.net.bean.UserResp;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * @author Linxz
 * 创建日期：2020年10月27日 10:29
 * version：
 * 描述：
 */
public class HttpClientCreator {
    private final Retrofit RETROFIT;
    private final GitHubService NETAPI;
    private volatile static HttpClientCreator creator;

    private HttpClientCreator(){
        RETROFIT =new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        NETAPI=RETROFIT.create(GitHubService.class);
    }

    public static HttpClientCreator getInstance(){
        if (creator==null){
            synchronized (HttpClientCreator.class){
               if (creator==null){
                   creator=new HttpClientCreator();
               }
            }
        }
        return creator;
    }

    public GitHubService gitHubApi(){
        return NETAPI;
    }

    public void login(){
        retrofit2.Call<List<UserResp>> call= NETAPI.listRepos("userName1");
        call.enqueue(new Callback<List<UserResp>>() {
            @Override
            public void onResponse(retrofit2.Call<List<UserResp>> call, Response<List<UserResp>> response) {
            }

            @Override
            public void onFailure(retrofit2.Call<List<UserResp>> call, Throwable t) {
            }
        });
    }

    public void okHttp() throws IOException {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("/login")
                .build();
        Call call=okHttpClient.newCall(request);
        call.execute();
    }
}
