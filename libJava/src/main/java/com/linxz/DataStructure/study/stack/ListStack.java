package com.linxz.DataStructure.study.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年01月04日 21:31
 * version：
 * 描述：
 */
public class ListStack<T> implements Stack<T>{

    private List<T> list=new ArrayList<>();

    @Override
    public void push(T t) {
        list.add(t);
    }

    @Override
    public T pop() {
        T t=list.get(list.size()-1);
        list.remove(t);
        return t;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean empty() {
        return list.size()==0;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i=0;i<list.size();i++){
            sb.append(list.get(i));
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListStack<String> mStack=new ListStack<>();
        mStack.push("1");
        mStack.push("2");
        mStack.push("3");
        mStack.push("4");
        System.out.println(mStack.toString());
        String tmp=mStack.pop();
        System.out.println(tmp);
        System.out.println(mStack.toString());


        //

    }
}
