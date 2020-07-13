package com.linxz.DataStructure.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 15:21
 * version：v4.5.4
 * 描述：
 */
public class LeetCode2Test {

    //给定两个数组，编写一个函数来计算它们的交集。 考虑重复元素

    //示例 1：
    //
    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2,2]
    //示例 2:
    //
    //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出：[4,9]
    // 
    //
    //说明：
    //
    //输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
    //我们可以不考虑输出结果的顺序。


    public static int[] intersect(int[] nums1, int[] nums2) {
        //value为出现的次数
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        for (Integer integer:nums1){
            if (!treeMap.containsKey(integer))
                treeMap.put(integer,1);
            else
                treeMap.put(integer,treeMap.get(integer)+1);
        }
        List<Integer> integerList=new ArrayList<>();
        for (Integer integer:nums2){
            if (treeMap.containsKey(integer)){
                integerList.add(integer);
                treeMap.put(integer,treeMap.get(integer)-1);
                if (treeMap.get(integer)==0){
                    treeMap.remove(integer);
                }
            }

        }
        int[] result=new int[integerList.size()];
        for (int i=0;i<integerList.size();i++){
            result[i]=integerList.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] num1={4,9,5};
        int[] num2={9,4,9,8,4};
        int[] result=intersect(num1,num2);
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        for (int value : result) {
            sb.append(value).append(",");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

}
