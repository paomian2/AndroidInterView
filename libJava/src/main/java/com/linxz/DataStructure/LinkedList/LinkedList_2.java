package com.linxz.DataStructure.LinkedList;

/**
 * 改进链表
 * 删除元素的时候，不需要从头开始去查询
 * 队首head负责删除元素，队尾tail负责插入元素
 * 由于没有dummyHead,要注意链表为空的情况
 * */
public class LinkedList_2<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

}
