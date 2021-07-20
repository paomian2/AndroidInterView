package com.streamlet.chain;



import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年07月19日 2:10 PM
 * version：
 * 描述：
 */
public class RealCall {

    private List<HandleInterceptor> interceptors = new ArrayList<>();
    private Request originalRequest;
    private CallBack callBack;


    public RealCall addInterceptor(HandleInterceptor interceptor){
        this.interceptors.add(interceptor);
        return this;
    }

    public RealCall request(Request request){
        this.originalRequest = request;
        return this;
    }

    public RealCall callback(CallBack callBack){
        this.callBack = callBack;
        return this;
    }


    public Response execute(){
       try {
           return getResponseWithInterceptorChain();
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }

    public void asyncExecute(){
        try {
            Response response = getResponseWithInterceptorChain();
            if (callBack != null){
                callBack.onResponse(response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Response getResponseWithInterceptorChain() throws Exception{
        if (originalRequest == null) throw new  NullPointerException("request can not be null");
        InterceptorChain chain = new InterceptorChain(0,originalRequest);
        return chain.proceed(originalRequest);
    }

    public class InterceptorChain implements HandleInterceptor.Chain {

        private final int index;
        private final Request request;

        public InterceptorChain(int index,Request request){
            this.index = index;
            this.request = request;
        }

        @Override
        public Response proceed(Request request) throws Exception {
            if (index < interceptors.size()){
                InterceptorChain chain = new InterceptorChain(index+1,request);
                HandleInterceptor interceptor = interceptors.get(index);
                Response interceptedResponse = interceptor.intercept(chain);
                if (interceptedResponse == null){
                    throw new NullPointerException("application interceptor " + interceptor
                            + " returned null");
                }
                return interceptedResponse;
            }
            return getResponse();
        }

        @Override
        public Request request() {
            return request;
        }

        Response getResponse(){
            Response response = new Response();
            response.setOk(true);
            response.setMessage("操作成功");
            return response;
        }
    }
}
