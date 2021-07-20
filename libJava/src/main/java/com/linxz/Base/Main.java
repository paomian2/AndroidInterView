package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2021年01月14日 23:43
 * version：
 * 描述：
 */
public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree=new Tree<>();
        tree.add(20);
        tree.add(3);
        tree.add(37);
        tree.add(6);
        tree.add(11);
        tree.add(5);
        tree.add(42);
        tree.add(18);
        tree.add(2);
        tree.print();
        System.out.println("-----------");
        System.out.println(tree.size);
    }
}
