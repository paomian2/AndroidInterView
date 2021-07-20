package com.linxz.classLoader;

/**
 * @author Linxz
 * 创建日期：2021年01月10日 22:47
 * version：
 * 描述：
 */
public class MineUser implements IUser{
    @Override
    public void play() {
        System.out.println("我会跑步啊");
    }

    @Override
    public void play2() {
        System.out.println("我会走路");
    }
}
