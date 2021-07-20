package com.streamlet.proxy2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 11:23 PM
 * version：
 * 描述：
 */
class MyRetrofit {
    public <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
                new InvocationHandler() {
                    @Override public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        //获取参数注解
                        StringBuilder hostSp=new StringBuilder();
                        StringBuilder sp=new StringBuilder();
                        Parameter[] parameters=method.getParameters();
                        for (int i=0;i<parameters.length;i++){
                            Parameter parameter=parameters[i];
                            if (parameter.isAnnotationPresent(Path.class)){
                                Path path=parameter.getAnnotation(Path.class);
                                parameter.getDeclaredAnnotations();
                                String key=path.value();
                                Object value=args[i];
                                sp.append(key);
                                sp.append("=");
                                sp.append(value);
                                sp.append("&");
                            }
                        }
                        //获取方法注解
                        if (method.isAnnotationPresent(GET.class)){
                            GET get=method.getAnnotation(GET.class);
                            hostSp.append(get.value());
                            hostSp.append("?");
                            hostSp.append(sp);
                        }else if (method.isAnnotationPresent(POST.class)){

                        }

                       System.out.println(hostSp.toString());
                       return null;
                    }
                });
    }

}
