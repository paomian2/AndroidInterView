package com.linxz.DataStructure.Map;
import java.util.HashMap;
/**
 * @author Linxz
 * 创建日期：2020年07月13日 14:12
 * version：v4.5.4
 * 描述：
 */
public class LeetCodeTest {

    //给定两个数组，编写一个函数来计算它们的交集。
    //示例 1：
    //
    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2]
    //示例 2：
    //
    //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //输出：[9,4]
    // 
    //
    //说明：
    //
    //输出结果中的每个元素一定是唯一的。
    //我们可以不考虑输出结果的顺序。


    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        HashMap<Integer,Integer> resultMap=new HashMap<>();
        for (Integer integer: nums1) {
            hashMap.put(integer,integer);
        }
        for (Integer integer: nums2) {
            Integer value=hashMap.get(integer);
            if (value!=null){
                resultMap.put(integer,integer);
            }
        }
        int[] result=new int[resultMap.size()];
        int i=0;
        for (HashMap.Entry<Integer, Integer> entry : resultMap.entrySet()){
            result[i]=entry.getValue();
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        int[] result=intersect(nums1,nums2);
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        for (int value : result) {
            sb.append(value).append(",");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }
}
