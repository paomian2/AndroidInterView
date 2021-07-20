package com.streamlet.chain;

import java.util.HashMap;

/**
 * @author Linxz
 * 创建日期：2021年07月19日 2:26 PM
 * version：
 * 描述：
 */
public class TestMain {


    public static void main(String[] args) {
        Request request = Request.builder()
                .setParams("token","redis123")
                .setParams("userName","风满楼")
                .setParams("avatar","https://xxxx")
                .build();
        RealCall realCall = new RealCall();
        Response response =
                realCall.request(request)
                .addInterceptor(new TokenDataHandler())
                .addInterceptor(new ValidDataHandle())
                .addInterceptor(new UpdatePasswordHandler())
                .addInterceptor(new SelectUserHandler())
                .execute();
        System.out.println(response);
    }


    public static class TokenDataHandler implements HandleInterceptor{
        @Override
        public Response intercept(Chain chain) throws Exception {
            Request request = chain.request();
            if (request.getParams().get("token") == null){
               return Response.error("token不能为空");
            }else if ("redis123".equals(request.getParams().get("toke"))){
                return Response.error("token错误");
            }
            //TODO 业务处理
            request.getParams().put("checkToken",true);
            return chain.proceed(request);
        }
    }

    public static class ValidDataHandle implements HandleInterceptor{

        @Override
        public Response intercept(Chain chain) throws Exception {
            Request request = chain.request();
            if (request.getParams().get("userName") == null && request.getParams().get("avatar") == null){
                return Response.error("要修改的账号信息不能为空");
            }
            //TODO 业务处理
            request.getParams().put("checkAccount",true);
            return chain.proceed(request);
        }
    }


    public static class UpdatePasswordHandler implements HandleInterceptor{
        @Override
        public Response intercept(Chain chain) throws Exception {
            Request request = chain.request();
            Object userName = request.getParams().get("userName");
            Object password = request.getParams().get("avatar");
            //TODO 业务处理 sql操作等
            boolean success = true;
            if (!success){
                return Response.error("修改密码失败");
            }
            request.getParams().put("newUserName","linxz");
            return chain.proceed(request);
        }
    }


    public static class SelectUserHandler implements HandleInterceptor{
        @Override
        public Response intercept(Chain chain) throws Exception {
            Request request = chain.request();
            Object userName = request.getParams().get("newUserName");
            HashMap<String,String> userInfo = new HashMap<>();
            userInfo.put("userName",userName+"");
            userInfo.put("avatar","https://xxxx");
            //TODO 业务处理
            return Response.ok(userInfo);
            //return chain.proceed(request);
        }
    }

}
