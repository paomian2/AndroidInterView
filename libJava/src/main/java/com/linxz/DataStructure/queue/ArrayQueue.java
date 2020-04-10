package com.linxz.DataStructure.queue;


import com.linxz.DataStructure.array.Array;

public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue(){
        array=new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.add(e);
    }

    @Override
    public E dequeue() {
        E e=array.get(getSize()-1);
        array.remove(array.getSize()-1);
        return e;
    }

    @Override
    public E getFront() {
        return array.get(getSize()-1);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        sb.append("End 【");
        for (int i=0;i<getSize();i++){
            sb.append(array.get(i));
            if (i!=getSize()-1){
                sb.append(" ");
            }
        }
        sb.append("] Top");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        for (int i=0;i<10;i++){
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue);
        System.out.println();

        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);
        System.out.println();

    }
}