package com.linxz.DataStructure.stack;

import com.linxz.DataStructure.LinkedList.LinkedList;

public class LinkedStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedStack(){
        linkedList=new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E pop() {
        E e=linkedList.getLast();
        linkedList.remove(linkedList.getSize()-1);
        return e;
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Linked Stack: size = %d\n", getSize()));
        sb.append("Top [");
        sb.append(linkedList);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack=new LinkedStack<>();
        for (int i=0;i<10;i++){
            linkedStack.push(i);
        }
        System.out.println(linkedStack);
        System.out.println();

        System.out.println(linkedStack.pop());
        System.out.println(linkedStack);
        System.out.println();


        System.out.println(linkedStack.getSize());
        System.out.println(linkedStack.peek());

        //链表栈比数组栈速度快，有的系统不一样，因为链表需要不断new
    }
}