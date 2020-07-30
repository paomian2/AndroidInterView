package com.linxz.algorithm.search;

/**
 * @author Linxz
 * 创建日期：2020年07月29日 08:34
 * version：v4.5.4
 * 描述：
 */
public class 查询_2折半查询 {

    public static void main(String[] args) {
        int[] array={5,13,19,21,37,56,64,75,80,88,92};
        int index=search(120,array);
        System.out.println(index);
    }

    public static int search(int e,int[] array){
        int low=0;
        int height=array.length-1;
        int middle=(low+height)/2;
        while (low<=height){
            if (array[middle]>e){
                height=middle-1;
            }else{
                low=middle+1;
            }
            middle=(low+height)/2;
        }
        if (array[middle]==e){
            return middle;
        }else{
            return -1;
        }
    }
}
