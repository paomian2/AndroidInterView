package com.linxz.classLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Linxz
 * 创建日期：2021年01月10日 22:36
 * version：
 * 描述：
 */
public class UserDao {


    private static IUser build(final IUser service){
       return (IUser) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("======pre======");
                Object o1=method.invoke(service, objects);
                System.out.println("======end======");
                return o1;
            }
        });
    }





    public static void main(String[] args) {
        IUser mineUser=new MineUser();
        IUser newIUser=build(mineUser);
        newIUser.play();
        newIUser.play2();
    }
}
