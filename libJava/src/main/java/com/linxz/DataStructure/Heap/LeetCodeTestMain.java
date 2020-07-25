package com.linxz.DataStructure.Heap;

import com.linxz.DataStructure.LinkedList.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Linxz
 * 创建日期：2020年07月16日 19:11
 * version：v4.5.4
 * 描述：
 */
public class LeetCodeTestMain {

    //前 K 个高频元素
    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    //
    // 
    //
    //示例 1:
    //
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    //示例 2:
    //
    //输入: nums = [1], k = 1
    //输出: [1]
    // 
    //
    //提示：
    //
    //你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    //你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
    //题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
    //你可以按任意顺序返回答案。


    public static void main(String[] args) {
        LeetCodeTestMain testMain=new LeetCodeTestMain();
        int[] nums = {1,2,3,-1,-1,2};
        int[] result = testMain.topKFrequent(nums, 2);
        System.out.print("[ ");
        for (int value : result) {
            System.out.print(value+",");
        }
        System.out.println(" ]");
    }


    private  class Freq implements Comparable<Freq>{
        private Integer e;
        private Integer freq;

        public Freq(Integer e,Integer freq){
            this.e=e;
            this.freq=freq;
        }


        @Override
        public int compareTo(Freq freq) {
            if (this.freq < freq.freq)
                return 1;
            else if (this.freq>freq.freq)
                return -1;
            return 0;
        }
    }


    public  int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        HashMap<Integer,Integer> kHasMap=new HashMap<>();
        List<Integer> integers=new ArrayList<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

//        PriorityQueue<Freq> pq=new PriorityQueue<>();
//        for (int key:hashMap.keySet()){
//            if (pq.getSize()<k)
//                pq.enqueue(new Freq(key,hashMap.get(key)));
//            else if (hashMap.get(key)>pq.getFront().freq){
//                pq.dequeue();
//                pq.enqueue(new Freq(key,hashMap.get(key)));
//            }
//        }
//
//
//        while (!pq.isEmpty()){
//            integers.add(pq.dequeue().e);
//        }

        //1.频率必须要大于K
        //2.将频次高于k的加入容器中(容器的size必须大于或等于k)。大于K之后继续遍历，如果该频率小于容器中的全部元素则不添加，
        //否则删除容器最小的元素，将该频率放入。
        //即：容器中的元素为大于等于K
        for (HashMap.Entry<Integer,Integer> entry:hashMap.entrySet()){
             if (kHasMap.size()<k){
                 kHasMap.put(entry.getKey(),entry.getValue());
             }else{
                 //如果该元素频率比容器中所有元素的频率都大
                 if (eBiggerThanMapOneElement(kHasMap,entry.getValue())){
                     //找出最小频率元素，删除最小频率的元素
                     Integer smallE=null;
                     for (HashMap.Entry<Integer,Integer> smallEntry:kHasMap.entrySet()){
                         if (smallE==null){
                             smallE=smallEntry.getKey();
                         }else if (smallEntry.getValue()<kHasMap.get(smallE)){
                             smallE=smallEntry.getKey();
                         }
                     }
                     kHasMap.remove(smallE);
                     kHasMap.put(entry.getKey(),entry.getValue());
                 }
             }
        }

        for (HashMap.Entry<Integer,Integer> entry:kHasMap.entrySet()){
            integers.add(entry.getKey());
        }
        int[] result=new int[integers.size()];
        for (int i=0;i<integers.size();i++){
            result[i]=integers.get(i);
        }
        return result;
    }

    private  boolean eBiggerThanMapOneElement(HashMap<Integer,Integer> hashMap,Integer val){
        for (HashMap.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if (val>entry.getValue()){
                return true;
            }
        }
        return false;
    }
}
