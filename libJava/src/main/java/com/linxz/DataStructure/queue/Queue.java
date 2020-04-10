package com.linxz.DataStructure.queue;

/**
 * 队列
 */
public interface Queue<E> {

    /**
     * 入队
     */
    void enqueue(E e);

    /**
     * 出对
     */
    E dequeue();

    /**
     * 获取队首元素
     */
    E getFront();

    boolean isEmpty();

    int getSize();
}