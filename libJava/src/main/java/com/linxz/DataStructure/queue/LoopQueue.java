package com.linxz.DataStructure.queue;

/**
 * 循环队列并不是真的表示整个容器是首尾连接，而是在删除元素的时候不容每个位置都进行移动，eg:[0,1,2,3,4,5,6,7,8,9],删除0，1位置的元素的时候得到：
 * [null,null,2,3,4,5,6,7,8,9]
 * 这个时候再添加元素的时候，并不会扩容，然后加入到9的后面，而是添加到前面的位置，如添加11的时候得到
 * [11,null,2,3,4,5,6,7,8,9]
 * <p>
 * 多出一个位置不放置元素，专门用来判断元素是否填满。tail指向之歌位置，如果这个位置的+1==队首元素，就认为元素已经填满，再添加的时候要进行扩容
 * 对首==对尾 队列标识为空
 * 对尾部+1个位置==对首( (tail+1)%容量==front ) 队列标识为填满数据
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private E[] data;
    /**
     * 对首位置
     */
    private int front;
    /**
     * 对尾位置
     */
    private int tail;
    private int size;

    public LoopQueue(int initCapacity) {
        data = (E[]) new Object[initCapacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(20);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            //元素已经填满
            resize(getCapacity() << 1);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        return data[front];
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
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        sb.append("[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((1 + 1) % data.length != tail) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        System.out.println();

        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue);
        System.out.println();
        //循环队列与数组队列相比，性能要都快很多，dequeue操作，循环队列不需要遍历，而数组队列需要遍历移动位置。数组队列插入的时候也有可能需要移动位置


    }
}