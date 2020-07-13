package com.linxz.DataStructure.Set;

import com.linxz.DataStructure.LinkedList.LinkedList;

/**
 * @author Linxz
 * 创建日期：2020年07月11日 09:03
 * version：v4.5.4
 * 描述：
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet(){
        linkedList=new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
