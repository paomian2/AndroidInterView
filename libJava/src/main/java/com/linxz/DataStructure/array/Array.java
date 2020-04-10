package com.linxz.DataStructure.array;

public class Array<E> {

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private E[] data;
    /**
     * 数组元素个数(不是数组的真实长度)
     */
    private int size;


    /**
     * 泛型无法直接实例化，所以使用object
     *
     * @param initialCapacity 数组的长度，保持与data.length一致。size为当前数组中元素的个数
     */
    public Array(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;

        data = (E[]) new Object[initialCapacity];
        size = 0;
    }

    public Array() {
        this(20);
    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int getCapacity() {
        return data.length;
    }

    private void checkIllegal(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index must >= 0 and < size");

        if (index >= MAXIMUM_CAPACITY)
            throw new IndexOutOfBoundsException("index must < MAXIMUM_CAPACITY");
    }

    /**
     * @return Array 这样可以使用链式调用
     * eg: array.set(0,stu0)
     * .set(1.stu1)
     */
    public Array<E> set(int index, E e) {
        checkIllegal(index);
        data[index] = e;
        return this;
    }

    public E get(int index) {
        checkIllegal(index);
        return data[index];
    }

    /**
     * 数组指定位置添加添加元素
     *
     * @param index 插入的位置
     * @param e     插入的元素
     * [0,1,2,3,4,5,6,7,8,9]
     */
    public Array add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must >= 0 and <= size");
        }

        if (size == data.length) {
            resize(data.length << 1);
        }

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;

        size++;
        return this;
    }

    /**
     * 添加在最后一个位置
     */
    public Array add(E e) {
        add(size, e);
        return this;
    }

    /**
     * 添加在第一个位置
     */
    public Array addFirst(E e) {
        add(0, e);
        return this;
    }

    public Array addAll(Array<E> array) {
        if (array == null) {
            throw new NullPointerException("Array can not be null.");
        }

        for (int i = 0; i < array.getSize(); i++) {
            add(array.get(i));
        }
        return this;
    }

    public Array addAll(int index, Array<E> array) {
        checkIllegal(index);

        if (array == null) {
            throw new NullPointerException("Array can not be null.");
        }

        for (int i = 0; i < array.getSize(); i++) {
            add(index + 1, array.get(i));
        }
        return this;
    }


    /**
     * 数组容量扩容/缩容，扩容大小为原来的2倍/二分之一
     *
     * @param capacity 扩容/缩容大小
     */
    private void resize(int capacity) {
        if (capacity >= MAXIMUM_CAPACITY)
            throw new IndexOutOfBoundsException("capacity must < MAXIMUM_CAPACITY");

        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }



    public Array remove(int index) {
        checkIllegal(index);

        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        if (size == data.length / 2) {
            resize(data.length >> 1);
        }
        return this;
    }

    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(E e){
        boolean hasEle=false;
        if (remove(e)){
            hasEle=true;
            removeAll(e);
        }
        return hasEle;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * 比clear来说更加消耗内存
     * */
    public void clear2(){
        data = (E[]) new Object[20];
        size = 0;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int count(E e){
        if (e == null) {
            throw new IllegalArgumentException("E can no be null.");
        }

        int count=0;
        for (int i=0;i<size;i++){
            if (e.equals(data[i])){
                count++;
            }
        }
        return count;
    }

    public int countNullElement() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * @deprecated replace with {@link Array#toNormalArray(Object[])}
     * 得到得是E其实是Object,会出现强制转化错误
     * eg:
     *  Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
     * */
    public E[] toNormalArray2(){
        E[] es= (E[]) new Object[size];
        System.arraycopy(data, 0, es, 0, size);
        return es;
    }

    /**
     *生成一个新的常规数组返回
     *    for (int i=0;i<size;i++){
     *            normalData[i]=data[i];
     *        }
     *
     * */
    public  E[] toNormalArray(E[] es){
        System.arraycopy(data, 0, es, 0, size);
        return es;
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
        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.add(Integer.parseInt(i + ""));
        }
        System.out.println(array);
        System.out.println();

        array.remove(0);
        System.out.println(array);
        System.out.println();

        array.add(1, Integer.parseInt(100 + ""));
        System.out.println(array);
        System.out.println();

        array.addFirst(Integer.parseInt(-1 + ""));
        System.out.println(array);
        System.out.println();

        System.out.println(array.get(Integer.parseInt(2 + "")));
        System.out.println();

        array.set(2, Integer.parseInt(0 + ""));
        System.out.println(array.get(Integer.parseInt(2 + "")));
        System.out.println();

        System.out.println(array.contains(Integer.parseInt(4 + "")));
        System.out.println(array.contains(Integer.parseInt(-1000 + "")));
        System.out.println();

        System.out.println(array.find(Integer.parseInt(4 + "")));
        System.out.println(array.find(Integer.parseInt(-1000 + "")));
        System.out.println();

        System.out.println(array);
        System.out.println(array.remove(Integer.parseInt(3 + "")));
        System.out.println(array);
        System.out.println();

        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        System.out.println(array);
        System.out.println();

        array.removeAll(-1);
        System.out.println(array);
        System.out.println();

        Array<Integer> array2=new Array<>();
        for(int i=100;i<130;i++){
            array2.add(i);
        }
        System.out.println("--------Array2--------");
        System.out.println(array2);
        System.out.println();


        array.addAll(array2);
        System.out.println(array);
        System.out.println();


        System.out.println("0的个数"+array.count(0));
        System.out.println();


        Integer[] normalData= array.toNormalArray(new Integer[array.getSize()]);
        System.out.print("常规数组：[");
        for (int i=0;i<normalData.length;i++){
            System.out.print(normalData[i]);
            if (i!=normalData.length-1){
                System.out.print(" ");
            }
        }
        System.out.println("】");
        System.out.println();


        //Integer[] normalData2= array.toNormalArray2();

    }

}