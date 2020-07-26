package com.linxz.letcode;

import java.util.HashMap;

/**
 * @author Linxz
 * 创建日期：2020年07月26日 13:56
 * version：v4.5.4
 * 描述：
 */
public class MockInterViews {

    //排排坐，分糖果。
    //
    //我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
    //
    //给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
    //
    //然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
    //
    //重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
    //
    //返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
    //
    //
    //
    //示例 1：
    //
    //输入：candies = 7, num_people = 4
    //输出：[1,2,3,1]
    //解释：
    //第一次，ans[0] += 1，数组变为 [1,0,0,0]。
    //第二次，ans[1] += 2，数组变为 [1,2,0,0]。
    //第三次，ans[2] += 3，数组变为 [1,2,3,0]。
    //第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
    //示例 2：
    //
    //输入：candies = 10, num_people = 3
    //输出：[5,2,3]
    //解释：
    //第一次，ans[0] += 1，数组变为 [1,0,0]。
    //第二次，ans[1] += 2，数组变为 [1,2,0]。
    //第三次，ans[2] += 3，数组变为 [1,2,3]。
    //第四次，ans[0] += 4，最终数组变为 [5,2,3]。

    public static void main(String[] args) {
        MockInterViews mockInterViews=new MockInterViews();
//        int[] ret=mockInterViews.distributeCandies(10,3);
//        for (int i=0;i<ret.length;i++){
//            System.out.print(ret[i]+" ");
//        }




        int[] nums={9,8,1,0,1,9,4,0,4,1};
        int ret=mockInterViews.maxWidthRamp(nums);
        System.out.println(ret);
    }


    public int[] distributeCandies(int candies, int num_people) {
        int[] peoplesCandies=new int[num_people];
        int i=0;
        while (candies>0){
            if (candies<=(i+1)){
                peoplesCandies[i%num_people]=peoplesCandies[i%num_people]+candies;
            }else{
                peoplesCandies[i%num_people]=peoplesCandies[i%num_people]+(i+1);
            }
            candies=candies-(i+1);
            i++;
        }
        return peoplesCandies;
    }









    //给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
    //
    //找出 A 中的坡的最大宽度，如果不存在，返回 0 。
    //
    //
    //
    //示例 1：
    //
    //输入：[6,0,8,2,1,5]
    //输出：4
    //解释：
    //最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
    //示例 2：
    //
    //输入：[9,8,1,0,1,9,4,0,4,1]
    //输出：7
    //解释：
    //最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.

    public int maxWidthRamp(int[] A) {
        //{6,0,8,2,1,5}
        //9,8,1,0,1,9,4,0,4,1
        int ret=0;
        //超时
//        for (int i=0;i<A.length;i++){
//            for (int j=0;j<A.length;j++){
//                if (j>i && A[i]<=A[j]){
//                    int temp=j-i;
//                    if (temp>ret){
//                        ret=temp;
//                    }
//                }
//            }
//        }

        HashMap<Integer,Integer> hashMap=new HashMap<>();
         for (int i=0;i<A.length;i++){
             hashMap.put(i,A[i]);
         }
         for (HashMap.Entry<Integer,Integer> entry:hashMap.entrySet()){
            for (int i=entry.getKey();i<A.length;i++){
                if (A[entry.getKey()]<=A[i]){
                    int temp=i-entry.getKey();
                    if (temp>ret){
                        ret=temp;
                    }
                }
            }
         }

        return ret;
    }



}
