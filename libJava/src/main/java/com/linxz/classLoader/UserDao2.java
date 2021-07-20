package com.linxz.classLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Linxz
 * 创建日期：2021年01月10日 23:17
 * version：
 * 描述：
 */
public class UserDao2 {


    @SuppressWarnings("unchecked")
    public static <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
                new InvocationHandler() {

                    @Override public Object invoke(Object proxy, Method method, Object... args)
                            throws Throwable {
                        // If the method is a method from Object then defer to normal invocation.
                        if (method.getDeclaringClass() == Object.class) {
                            System.out.println("00000");
                            return method.invoke(this, args);
                        }
                        System.out.println("2222");
                       return null;
                    }
                });
    }


    public static void main(String[] args) {
       IUser iUser= UserDao2.create(IUser.class);
     //  System.out.println(iUser);
    }


}
