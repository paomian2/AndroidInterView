package com.linxz.algorithm.sort;

/**
 * @author Linxz
 * 创建日期：2020年07月29日 07:48
 * version：v4.5.4
 * 描述：
 */
public class 排序_ {

    public static void main(String[] args) {
        int[] array={156,88,141,111,35,100};
        sortArray(array);
        for (int a:array){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("遍历次数："+count);
    }

    static int count=0;

    public static int[] sortArray(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j=i;j<array.length;j++){
                if (array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
                count++;
            }
        }
        return array;
    }
}
