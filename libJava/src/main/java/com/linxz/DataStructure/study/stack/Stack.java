package com.linxz.DataStructure.study.stack;

/**
 * @author Linxz
 * 创建日期：2021年01月04日 21:29
 * version：
 * 描述：
 */
public interface Stack<T> {

    void push(T t);

    T pop();

    int size();

    boolean empty();
}
