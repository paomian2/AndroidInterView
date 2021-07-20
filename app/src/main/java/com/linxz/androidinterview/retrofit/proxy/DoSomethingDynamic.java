package com.linxz.androidinterview.retrofit.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * @author Linxz
 * 创建日期：2021年03月04日 1:41 AM
 * version：
 * 描述：
 */
class DoSomethingDynamic {


    public <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
                new InvocationHandler() {
                    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       // return serviceMethod.callAdapter.adapt(okHttpCall);

                       return null;
                    }
                });
    }
}
