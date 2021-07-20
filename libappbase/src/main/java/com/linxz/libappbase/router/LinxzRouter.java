package com.linxz.libappbase.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Linxz
 * 创建日期：2021年04月19日 11:56 AM
 * version：
 * 描述：
 */
public class LinxzRouter {

    private static volatile LinxzRouter linxzRouter;

    private HashMap<String,Class<?>> activityMap=new HashMap<>();

    private LinxzRouter(){}

    public static LinxzRouter getInstance(){
        if (linxzRouter == null){
            synchronized (LinxzRouter.class){
               if (linxzRouter == null){
                   linxzRouter=new LinxzRouter();
               }
            }
        }
        return linxzRouter;
    }

    public void init(Context context){
        Scanner scanner=new Scanner();
        try {
            Set<Class<?>> clsList =  new HashSet<>();
            Set<Class<?>> groupApp=scanner.scan(context,"com.linxz.libapp");
            Set<Class<?>> groupApp2=scanner.scan(context,"com.linxz.libapp2");
            clsList.addAll(groupApp);
            clsList.addAll(groupApp2);
            if (clsList.size() > 0) {
                for (Class<?> cls : clsList) {
                    if (cls.getAnnotation(LinxzPath.class) != null) {
                        String pageUrl=cls.getAnnotation(LinxzPath.class).value();
                        activityMap.put(pageUrl,cls);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bindActivity(String pageUrl,Class<?> clz){
        if (activityMap.get(pageUrl) == null){
            activityMap.put(pageUrl,clz);
        }
    }


    public void navigation(Activity activity,String pageUrl){
        Class<?> target=activityMap.get(pageUrl);
        if (target != null){
            Intent intent=new Intent(activity,target);
            activity.startActivity(intent);
        }
    }
}
