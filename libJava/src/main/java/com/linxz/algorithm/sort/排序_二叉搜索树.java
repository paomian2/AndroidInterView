package com.linxz.algorithm.sort;

import com.linxz.DataStructure.Tree.BST;

import java.util.List;

/**
 * @author Linxz
 * 创建日期：2020年07月29日 07:57
 * version：v4.5.4
 * 描述：
 */
public class 排序_二叉搜索树 {

    public static void main(String[] args) {
        int[] array={156,88,141,111,35,100};
        array=sortArray(array);
        for (int a:array){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("遍历次数："+count);
    }

    static int count=0;

    public static int[] sortArray(int[] array){
        BST<Integer> bst=new BST<>();
        for (int a:array){
            bst.add(a);
            count++;
        }
        List<Integer> list=bst.queryList();
        int[] ret=new int[list.size()];
        for (int i=0;i<list.size();i++){
            ret[i]=list.get(i);
            count++;
        }
        return ret;
    }
}
