package com.linxz.DataStructure.stack;

public interface Stack<E> {

    /**栈元素的个数*/
    int getSize();
    /**是否是空栈*/
    boolean isEmpty();
    /**新元素入栈*/
    void push(E e);
    /**元素出栈*/
    E pop();
    /**查看栈顶元素*/
    E peek();

}