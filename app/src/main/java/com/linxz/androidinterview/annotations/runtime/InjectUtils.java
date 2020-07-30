package com.linxz.androidinterview.annotations.runtime;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @author Linxz
 * 创建日期：2020年07月30日 13:59
 * version：v4.5.4
 * 描述：
 */
public class InjectUtils {

    public static void inject(Activity activity){
        injectActivityContentView(activity);
        injectView(activity);
        injectOnclick(activity);
    }

    private static void injectActivityContentView(Activity activity){
        Class<? extends Activity> clzz=activity.getClass();
        ContentView contentView=clzz.getAnnotation(ContentView.class);
        if (contentView==null)
            return;
        int contentViewId=contentView.value();
        try {
            Method setContentViewMethod=clzz.getMethod("setContentView",int.class);
            setContentViewMethod.setAccessible(true);//获取该方法的访问权
            setContentViewMethod.invoke(activity,contentViewId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void injectView(Activity activity){
        Class<? extends Activity> clazz=activity.getClass();
        //根据class类信息获取该类的全部全局变量
        Field[] fields=clazz.getDeclaredFields();//getDeclaredField获取全部的，getFields只能获取公有的
        for (Field field:fields){
            //获取标在变量上的注解的值
            BindView bindView=field.getAnnotation(BindView.class);
            if (bindView==null)
                continue;
            int viewId=bindView.value();
            try {
                //获取activity的方法
                Method findByIdMethod=clazz.getMethod("findViewById",int.class);
                findByIdMethod.setAccessible(true);
                field.setAccessible(true);
                //执行findViewById方法
                Object viewObject=findByIdMethod.invoke(activity,viewId);
                //变量赋值
                field.set(activity,viewObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    //        textView.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //
    //            }
    //        });
    //@ViewClick({viewId1,viewId2})
    //public void onclick(View view){}
//    private static void injectOnclick(Activity activity){
//        Class<? extends Activity> clazz=activity.getClass();
//        //获取clazz类中的所有的方法,getMethods为获取所以公有的方法
//        Method[] methods=clazz.getDeclaredMethods();
//        for (Method method:methods){
//            ViewOnClick viewOnClick=method.getAnnotation(ViewOnClick.class);
//            if (viewOnClick==null)
//                continue;
//            //获取方法中的所有注解
//            Annotation[] annotations=method.getDeclaredAnnotations();
//            for (Annotation annotation:annotations){
//               Class<? extends Annotation> annotationType= annotation.annotationType();
//               //获取注解中的注解
//               OnClickEvent onClickEvent=annotationType.getAnnotation(OnClickEvent.class);
//               if (onClickEvent==null)
//                   continue;
//                String listenerSetter=onClickEvent.listenerSetter();//setOnClickListener
//                Class<?> listenerType=onClickEvent.listenerType();//View.OnClickListener
//                String methodName=onClickEvent.methodName();//onClick(View v)
//                ListenerInvocationHandler handler=new ListenerInvocationHandler(activity);
//                handler.setMethod(methodName,method);
//                Object object= Proxy.newProxyInstance(listenerType.getClassLoader(),new Class<?>[]{listenerType},handler);
//
//                int[] viewIds=viewOnClick.value();
//                for (int viewId:viewIds){
//                    try {
//                        //根据id获取对应的view
//                        Method findByIdMethod = clazz.getMethod(ACTIVITY_MAIN_FINDVIEWBYID,int.class);
//                        findByIdMethod.setAccessible(true);
//                        //执行findViewById方法
//                        Object viewObject=findByIdMethod.invoke(activity,viewId);
//                        //view执行setOnclickListener
//                        Method m=viewObject.getClass().getMethod(listenerSetter, listenerType);
//                        //调用方法
//                        m.invoke(viewObject,object);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }



    //        textView.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View v) {
    //
    //            }
    //        });
    private static void injectOnclick(Activity activity){
        Class<? extends Activity> clazz=activity.getClass();
        //获取clazz类中的所有的方法,getMethods为获取所以公有的方法
        Method[] methods=clazz.getDeclaredMethods();
        for (Method method:methods){
            ViewOnClick viewOnClick=method.getAnnotation(ViewOnClick.class);
            if (viewOnClick==null)
                continue;
            //获取方法中的所有注解
                //获取注解中的注解
                ListenerInvocationHandler handler=new ListenerInvocationHandler(activity,method);
                Object object= Proxy.newProxyInstance(View.OnClickListener.class.getClassLoader(),new Class<?>[]{View.OnClickListener.class},handler);

                int[] viewIds=viewOnClick.value();
                for (int viewId:viewIds){
                    try {
                        //根据id获取对应的view
                        Method findByIdMethod = clazz.getMethod("findViewById",int.class);
                        findByIdMethod.setAccessible(true);
                        //执行findViewById方法实力化View
                        Object viewObject=findByIdMethod.invoke(activity,viewId);
                        //view执行setOnclickListener
                        Method setOnClickListener=viewObject.getClass().getMethod("setOnClickListener", View.OnClickListener.class);
                        //调用方法 将setOnClickListener中的onClick执行之后回调到带有该注解的方法上
                        setOnClickListener.invoke(viewObject,object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }
    }





    private static class ListenerInvocationHandler implements InvocationHandler {
        private Object object;
        private Method injectMethod;

        public ListenerInvocationHandler(Object object,Method method){
            this.object=object;
            this.injectMethod=method;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (proxy==null)
                return null;
            String name=method.getName();
            if ("onClick".equals(name) && injectMethod!=null){
                //执行onClick方法的时候，执行注解方法，执行的参数为onClick的参数
                return injectMethod.invoke(object,args);
            }
            return null;
        }
    }
}
