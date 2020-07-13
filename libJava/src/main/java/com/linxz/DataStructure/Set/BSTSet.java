package com.linxz.DataStructure.Set;

import com.linxz.DataStructure.Tree.BST;

/**
 * @author Linxz
 * 创建日期：2020年07月11日 08:50
 * version：v4.5.4
 * 描述：
 */
public class BSTSet<E extends  Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(){
        bst=new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
       bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
