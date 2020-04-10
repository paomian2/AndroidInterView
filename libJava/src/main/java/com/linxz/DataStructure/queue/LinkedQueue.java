package com.linxz.DataStructure.queue;

public class LinkedQueue<E> implements Queue<E>{

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
    private Node tail;
    private int size;

    @Override
    public void enqueue(E e) {
        Node newNode=new Node(e);
        if (tail==null){
            tail= newNode;
            head=tail;
        }else{
            tail.next=newNode;
            tail=tail.next;
        }
        size++;
    }



    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node delNode=head;
        head=head.next;
        delNode.next=null;
        if (head==null){
            tail=null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Queue: size = %d\n", getSize()));
        Node cur=head;
        while (cur!=null){
            sb.append(cur).append("->");
            cur=cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue=new LinkedQueue<>();
        for (int i=0;i<10;i++){
            linkedQueue.enqueue(i);
        }
        System.out.println(linkedQueue);
        System.out.println();

        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue);
        System.out.println();

    }
}