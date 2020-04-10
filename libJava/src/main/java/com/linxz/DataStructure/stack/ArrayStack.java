package com.linxz.DataStructure.stack;

import com.linxz.DataStructure.array.Array;


/**
 * 不允许获取非栈顶的元素
 * */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(){
        array=new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addFirst(e);
    }

    @Override
    public E pop() {
        E e=array.get(0);
        array.remove(0);
        return e;
    }

    @Override
    public E peek() {
        return array.get(0);
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Stack: size = %d, capacity = %d\n", getSize(), getCapacity()));
        sb.append("Top [");
        for (int i=0;i<getSize();i++){
            sb.append(array.get(i));
            if (i!=getSize()-1){
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        for (int i=0;i<10;i++){
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        System.out.println();

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);
        System.out.println();


        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.getCapacity());
        System.out.println(arrayStack.peek());
    }
}