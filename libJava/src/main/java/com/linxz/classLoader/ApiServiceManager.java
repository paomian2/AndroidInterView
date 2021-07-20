package com.linxz.classLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author Linxz
 * 创建日期：2021年01月10日 23:32
 * version：
 * 描述：
 */
public class ApiServiceManager {


    @SuppressWarnings("unchecked")
    public <T> T init(Class<T> clazz){
        Method[] methods=ApiService.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
//            Annotation[]  annotations=method.getDeclaredAnnotations();
//            for (Annotation annotation : annotations) {
//                System.out.println(annotation);
//
//            }
            if (method.isAnnotationPresent(GET.class)){
                GET get=method.getAnnotation(GET.class);
               String value= get.value();
               System.out.println(value);
            }
        }

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object ...objects) throws Throwable {
                System.out.println("invoke method...pre");
                Object result=method.invoke(this,objects);
                System.out.println("invoke method...end");
                return result;
            }
        });
    }


    public static void main(String[] args) {
        ApiServiceManager manager=new ApiServiceManager();
        ApiService apiService= manager.init(ApiService.class);
        System.out.println(apiService);
    }
}
