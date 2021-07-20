package com.linxz.DataStructure.array;

public class A_数组 {

    /*
     * 数组（array）是一种最简单的复合数据类型，它是有序数据的集合，数组中的每个元素具有相同的数据类型
     * 1.最大优点：查询快
     * 2.数组最好应用于"索引"有语义
     * 3.长度不可变
     *
     * 三个基本特性：
     * 一致性：数组只能保存相同数据类型元素，元素的数据类型可以是任何相同的数据类型。
     * 有序性：数组中的元素是有序的，通过下标访问。
     * 不可变性：数组一旦初始化，则长度（数组中元素的个数）不可变。
     * */

    public static void main(String[] args){
        int[] arr=new int[20];
        for (int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        while (true){
            //
        }

    }






}