package com.linxz.DataStructure.array;

/**
 * 自定义数组
 * 支持动态长度
 */
public class MyArray {

    private int[] data;
    private int size;


    public MyArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }


    public MyArray() {
        this(20);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add failed.Array is full.");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<size");

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }


    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is outof size");

        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is outof size");

        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    public int remove(int index){
        if (index<=0 || index>=size)
            throw new IllegalArgumentException("Delete faild. Require index>=0 and index<size");

        int val=data[index];

        for (int i=index+1;i<size;i++)
            data[i-1]=data[i];

        size--;

        return val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
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
        MyArray array = new MyArray(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
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

        System.out.println(array);
        System.out.println(array.remove(Integer.parseInt(3+"")));
        System.out.println(array);
        System.out.println();


        System.out.println(array);
        System.out.println(array.remove(Integer.parseInt(3+"")));
        System.out.println(array);
        System.out.println();
    }
}