package com.linxz.algorithm.sort;

/**
 * @author Linxz
 * 创建日期：2020年07月29日 08:14
 * version：v4.5.4
 * 描述：
 */
public class 排序_2直接插入排序 {

    public static void main(String[] args) {
        int[] array={156,88,141,111,35,100};
        int[] newArray=sortArray(array);
        for (int a:newArray){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("遍历次数："+count);
    }

    static int count=0;

    public static int[] sortArray(int[] array){
        int[] newArray=new int[array.length];
        for (int i=0;i<array.length;i++){
            insert(array[i],newArray);
            count++;
        }
        return newArray;
    }

    public static void insert(int e,int[] array){
        //要插入的下标
        int index=0;

        for (int i=0;i<array.length;i++){
            if (e<=array[i]){
                index=i;
                break;
            }
            count++;
        }
        for (int i=array.length-1;i>index;i--){
            array[i]=array[i-1];
            count++;
        }
        array[index]=e;
    }
}
