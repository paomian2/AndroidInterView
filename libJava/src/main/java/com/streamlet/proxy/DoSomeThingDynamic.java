package com.streamlet.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Linxz
 * 创建日期：2021年03月04日 8:42 AM
 * version：
 * 描述：
 */
class DoSomeThingDynamic {

    private Object object;

    public DoSomeThingDynamic(Object obj){
        this.object=obj;
    }

    public <T> T create(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
                new InvocationHandler() {
                    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("***方法开始前工作****");
//                        if (method.getDeclaringClass() == Object.class) {
//                            System.out.println(this);
//                            return method.invoke(this, args);
//                        }
//                        System.out.println("***方法结束工作****");
                        return null;
                    }
                });
    }


}
