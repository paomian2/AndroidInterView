package com.linxz.letcode.Sum;

public class Sum_1 {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * 使用递归
     * */
    public static int sum(int[] arr,int index){
        if (index==arr.length){
            return 0;
        }else{
            return arr[index]+sum(arr,index+1);
        }
    }


    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(sum(nums));
    }
}