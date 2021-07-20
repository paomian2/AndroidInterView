package com.linxz.DataStructure.study.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年01月04日 22:38
 * version：
 * 描述：
 */
public class ListQueue<T> {
    List<T> list = new ArrayList<>();

    public void enqueue(T t) {
        list.add(t);


    }

    public T dequeue() {
        if (empty()) return null;
        T t = list.get(0);
        list.remove(0);
        return t;

    }

    public boolean empty() {
        return list.size() == 0;

    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            stringBuilder.append(",");

        }
        stringBuilder.append("]");
        return stringBuilder.toString();


    }


}
