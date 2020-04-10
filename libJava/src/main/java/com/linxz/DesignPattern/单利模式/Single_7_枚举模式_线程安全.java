package com.linxz.DesignPattern.单利模式;

/**
 * 写法简单/线程安全
 * */
public class Single_7_枚举模式_线程安全 {


    private Single_7_枚举模式_线程安全(){}

    private enum SingleEum{
        INSTANCE;//这个就是SingleEum的一个实例
        private Single_7_枚举模式_线程安全 instance;
        private SingleEum(){
            instance=new Single_7_枚举模式_线程安全();
        }
        public Single_7_枚举模式_线程安全 getInstance(){
            return instance;
        }
    }


    public static Single_7_枚举模式_线程安全 getInstance(){
        return SingleEum.INSTANCE.getInstance();
    }

}
