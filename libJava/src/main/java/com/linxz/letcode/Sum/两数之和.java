package com.linxz.letcode.Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Linxz
 * 创建日期：2020年07月26日 13:05
 * version：v4.5.4
 * 描述：
 */
public class 两数之和 {

    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    //
    // 
    //
    //示例:
    //
    //给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]


    public static void main(String[] args) {
        两数之和 solution=new 两数之和();
        int[] nums={2, 7, 11, 15};
        int target=9;
        int[] ret=solution.twoSum(nums,target);
        for (int index:ret){
            System.out.println(index);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        if (nums==null || nums.length==0)
            throw new IllegalArgumentException("nums can not be empty");
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            hashMap.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int element=target-nums[i];
            if (hashMap.containsKey(element) && hashMap.get(element)!=i){
                return new int[]{hashMap.get(element),i};
            }
        }
        return null;
    }


    public int[] twoSum0(int[] nums, int target) {
       if (nums==null || nums.length==0)
           throw new IllegalArgumentException("nums can not be empty");
       for (int i=0;i<nums.length;i++){
           for (int j=0;j<nums.length;j++){
               if (i!=j && nums[i]+nums[j]==target){
                   return new int[]{i,j};
               }
           }
       }
       return null;
    }
}
