package com.linxz.DataStructure.LinkedList;

public class LinkedList_1<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
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

    private Node head;
    private Node prev;
    private int size;

    public LinkedList_1() {
        head = null;
        size = 0;
    }

    /**
     * 添加到头节点
     */
    public void addFirst(E e) {
//        Node newNode=new Node(e);
//        newNode.next=head;
//        head=newNode;
        head = new Node(e, head);
        size++;
    }


    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index out of size.");

        if (index==0){
            addFirst(e);
            return;
        }

        Node tempPrev = head;
        for (int i = 0; i < index-1; i++) {
            tempPrev = tempPrev.next;
        }
//        tempPrev的下一个元素是新元素，tempPrev原来的下一个元素是连接到新元素的下一个元素
//        Node newNode=new Node(e);
//        newNode.next=tempPrev.next;
//        tempPrev.next=newNode;
        tempPrev.next=new Node(e,tempPrev.next);
        size++;
    }

    public void addLast(E e){
        add(size,e);
    }


    public E remove(int index) {
        if (index <  0 || index > size)
            throw new IllegalArgumentException("remove failed.Illegal index out of size.");

        Node tempPrev = head;
        for (int i = 0; i < index - 1; i++) {
            tempPrev = tempPrev.next;
        }
        Node indexNode = tempPrev.next;
        tempPrev.next = tempPrev.next.next;
        size--;
        return indexNode.e;
    }

    public boolean remove(E e){
        if (size==0){
            return false;
        }
        Node tempPrev = head;
        for (int i = 0; i < size; i++) {
            tempPrev = tempPrev.next;

        }
        return false;
    }

}