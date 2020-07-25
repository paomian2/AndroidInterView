package com.linxz.DataStructure.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Linxz
 * 创建日期：2020年07月17日 11:26
 * version：v4.5.4
 * 描述：
 */
public class LeetCodeTestMain2 {


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




    public int[] topKFrequent(int[] nums, int k) {
        final TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        //java库中PriorityQueue为最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return hashMap.get(a)-hashMap.get(b);
            }
        });
        for (int key : hashMap.keySet()) {
            if (pq.size() < k)
                pq.add(key);
            else if (hashMap.get(key) > hashMap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        List<Integer> integers=new ArrayList<>();
        while (!pq.isEmpty()) {
            integers.add(pq.remove());
        }

        int[] result=new int[integers.size()];
        for (int i=0;i<integers.size();i++){
            result[i]=integers.get(i);
        }

        return result;
    }
}
