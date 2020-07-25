package com.linxz.DataStructure.Heap;

import com.linxz.DataStructure.queue.Queue;


/**
 * @author Linxz
 * 创建日期：2020年07月16日 19:04
 * version：v4.5.4
 * 描述：优先队列
 *      普工队列：先进先出
 *      优先队列:优先级高的先出
 *
 *      最大堆：根解结点一定是最大值  所以把优先级定义为结点可以实现优先队列
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }
}
