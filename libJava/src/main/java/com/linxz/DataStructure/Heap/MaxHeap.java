package com.linxz.DataStructure.Heap;

import com.linxz.DataStructure.array.Array;
/**
 * @author Linxz
 * 创建日期：2020年07月13日 18:31
 * version：v4.5.4
 * 描述：最大堆
 *
 *       完全二叉树：数据一层一层从左到右往下放。第1层1个结点，第二层两个结点...(从0开始)
 *
 *       最大堆：完全二叉树、父结点大于等于子结点，左右孩子结点大小不比较(根结点最大)
 *
 *                              62
 *
 *                      41             30
 *
 *                  28      16     22       13
 *
 *      使用数组实现的情况下，父、子结点的索引如下：父结点(i),左子结点(2*i),右子结点(2*i+1)
 *                        修改为从第0层开始索引：父结点(i),左子结点(2*i+1),右子结点(2*i+2)
 *
 */
public class MaxHeap<E extends Comparable<E>> {


    private Array<E> data;
    private int CAPACITY=16;

    public MaxHeap(){
        data=new Array<>(CAPACITY);
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index==0)
            throw new IllegalArgumentException("index-0 do not have parent.");
        return ( index-1)/2;
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }

    public void add(E e){
       //往末尾添加元素
        data.addLast(e);
        //维护最大堆的性质，父结点一定要会大于子结点
        siftUp(data.getSize()-1);
    }

    /**
     * 上浮
     * 场景：添加元素的时候都是添加都最后一个位置
     *      为确保父结点一定>=子结点。
     *      只需对比父结点
     * */
    private void siftUp(int k){

        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k=parent(k);
        }
    }


    /**
     * 下沉
     *  场景：元素互换
     *  需要同时对比左、右子树结点。同时跟两结点比较，往最大的那个结点下沉
     * */
    private void siftDown(int k){
        //判断子结点索引是否比数组的长度要大
        while (leftChild(k)<data.getSize()){
            int j=leftChild(k);
            //j+1是右结点的意思。右结点比左结点大。确保j索引的是最大值的子结点
            if (j+1<data.getSize() && data.get(j+1).compareTo(data.get(j))>0)
                j=rightChild(k);
            if (data.get(k).compareTo(data.get(j))>=0)
                break;
            //符合条件，开始下沉
            data.swap(k,j);
            k=j;
        }
    }

   //查看堆中的最大元素
    public E findMax(){
       if (data.getSize()==0)
           throw new IllegalArgumentException("Can not findMax when heap is empty");
       return data.get(0);
    }

    //取出堆中最大元素,取出根元素
    public E extractMax(){
       E ret=findMax();
       //取出了元素之后，把最后一个结点移动到根结点，然后删除最后一个叶子结点。然后对比，把最大的元素换换上来
       data.swap(0,data.getSize()-1);
       data.removeLast();
       siftDown(0);
       return ret;
    }



    /**
     * 新元素替换最大的元素(新元素将根元素替换)
     * 方法1： extractMax，add. 时间复杂度：2次O(logn)
     * 方法2： 直接将根元素替换，然后将该元素比较、下沉  时间复杂度 1次O(logn)
     * */
    public E repace(E e){
       E ret=findMax();
       data.set(0,e);
       siftDown(0);
       return ret;
    }


    /**
     * 将一个数组改成堆
     * 方法1：扫描一下数组，添加到堆中       时间复杂度是O(nlogn)
     * 方法2：将数组看成一个完全二叉树。从最后一个非叶子结点开始计算，不断倒着向前siftDown操作  O(n)
     *        通过最后一个元素索引计算出倒数第一个非叶子结点的索引
     * */
//    public void heapify(E[] arr){
//
//    }
    public MaxHeap(E[] arr){
        data=new Array<>(arr);
        for (int i=parent(arr.length-1);i>=0;i--)
            siftDown(i);
    }


}
