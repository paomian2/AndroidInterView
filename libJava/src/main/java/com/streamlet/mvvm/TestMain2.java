package com.streamlet.mvvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Linxz
 * 创建日期：2021年07月16日 3:00 PM
 * version：
 * 描述：
 */
public class TestMain2 {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("123");
        TestMain2 testMain2 = new TestMain2();
        Application application = new Application();
       // UserModel userModel = testMain2.create(UserModel.class,application);
        //userModel.onAction();
        //Class<?> class1 = Class.forName("com.streamlet.mvvm.Application");
       // Application application1 = (Application) class1.getConstructors()[0].newInstance();
        //application1.print();
        UserModel userModel = testMain2.create(UserModel.class,application);
        userModel.onAction();
    }

    public <T extends ViewModel> T create(Class<T> modelClass,Application mApplication) {
        try {
            Constructor constructor = modelClass.getConstructor(Application.class);
            System.out.println(constructor);
            return modelClass.getConstructor(Application.class).newInstance(mApplication);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        }
    }
}
