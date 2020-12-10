package com.linxz.net;

import com.linxz.net.bean.UserResp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Linxz
 * 创建日期：2020年10月27日 10:22
 * version：
 * 描述：
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<UserResp>> listRepos(@Path("user") String user);
}
