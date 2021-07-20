package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2021年01月14日 23:27
 * version：
 * 描述：
 */
public class Tree<E extends Comparable<E>> {
    public class Node {
        E value;
        Node left;
        Node right;

        public Node(E value) {
            this.value = value;

        }

    }

    Node root;
    int size;

    public void add(E value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            add(root, value);
        }
    }

    public void add(Node node, E value) {
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node(value);
                size++;

            } else {
                add(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                size++;

            } else {
                add(node.right, value);

            }
        }

    }

    public void print() {
        if (root == null) {
            System.out.println("empty");

        } else {
            printTree(root);

        }
    }

    public void printTree(Node node){
        if(node.left!=null){
            printTree(node.left);
        }
        System.out.println(node.value);
        if(node.right!=null){
            printTree(node.right);
        }


    }
}
