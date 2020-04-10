package com.linxz.DataStructure.array;

/**
 * 使用泛型，不支持基本数据类型，只能是类对象(八种数据类型)
 * boolean byte char short int long float double
 * 支持扩容，达到最大的时候添加元素的时候，resize一下，重新构造出一个新的data
 */
public class MyArray2<E> {
    private E[] data;
    private int size;


    public MyArray2(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }


    public MyArray2() {
        this(20);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<size");

        if (size == data.length){
            resize(2*data.length);
        }


        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }


    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is outof size");

        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is outof size");

        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (index <= 0 || index >= size)
            throw new IllegalArgumentException("Delete faild. Require index>=0 and index<size");

        E val = data[index];

        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        size--;
        data[size]=null;

        if (size==data.length/2){
            resize(data.length/2);
        }

        return val;
    }

    private void resize(int newCapacity){
        E[] newData= (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++)
            newData[i]=data[i];
        data=newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array2: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        MyArray2<Integer> array = new MyArray2<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(Integer.parseInt(i+""));
        }
        System.out.println(array);
        System.out.println();

        array.add(1, Integer.parseInt(100+""));
        System.out.println(array);
        System.out.println();

        array.addFirst(Integer.parseInt(-1+""));
        System.out.println(array);
        System.out.println();

        System.out.println(array.get(Integer.parseInt(2+"")));
        System.out.println();

        array.set(2, Integer.parseInt(0+""));
        System.out.println(array.get(Integer.parseInt(2+"")));
        System.out.println();

        System.out.println(array.contains(Integer.parseInt(4+"")));
        System.out.println(array.contains(Integer.parseInt(-1000+"")));
        System.out.println();

        System.out.println(array.find(Integer.parseInt(4+"")));
        System.out.println(array.find(Integer.parseInt(-1000+"")));
        System.out.println();

        System.out.println(array);
        System.out.println(array.remove(Integer.parseInt(3+"")));
        System.out.println(array);
        System.out.println();

    }
}