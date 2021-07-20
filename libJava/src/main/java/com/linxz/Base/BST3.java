package com.linxz.Base;

import java.util.HashMap;

/**
 * @author Linxz
 * 创建日期：2021年01月14日 23:01
 * version：
 * 描述：
 */
public class BST3<E extends Comparable<E>> {

    public class Node{
        public Node left;
        public Node right;
        public E value;
        public Node(E e){
            this.value=e;
        }
    }

    private Node root;
    private int size;

    public void add(E e){
        if (root==null){
            root=new Node(e);
            size++;
        }else{
            add(root,e);
        }
    }

    public void add(Node node,E e){
        if (e.compareTo(node.value)<0){
            if (node.left==null){
                node.left= new Node(e);
                size++;
            }else{
                add(node.left,e);
            }
        }else{
            if (node.right==null){
                node.right=new Node(e);
                size++;
            }else{
                add(node.right,e);
            }
        }
    }


    public void query(){
        if (root==null){
            System.out.println("This is a empty tree");
        }else {
            query2(root);
        }

    }

    private void query2(Node node){
        if (node.left!=null){
            query2(node.left);
        }
        System.out.println(node.value);
        if (node.right!=null){
            query2(node.right);
        }
    }


    public static void main(String[] args) {
        BST3<Integer> bst3=new BST3<>();
        bst3.add(42);
        bst3.add(37);
        bst3.add(12);
        bst3.add(18);
        bst3.add(6);
        bst3.add(11);
        bst3.add(5);
        bst3.add(20);
        bst3.add(1);
        bst3.query();
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("key","value");
    }

}
