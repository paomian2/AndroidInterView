package com.linxz.DataStructure.Tree;


/**
 * @author Linxz
 * 创建日期：2021年01月13日 23:57
 * version：
 * 描述：
 */
public class BST2<E extends Comparable<E>>{



    public class Node{
        private Node left;
        private Node right;
        private E value;
        public Node(E value){
            this.value=value;
        }
    }

    private Node parent;
    private int size;



    public void add(E value){
       if (parent==null){
           parent=new Node(value);
           size++;
       }else{
           add2(parent,value);
       }
    }

    private void add2(Node node,E value){
        if (value.compareTo(node.value)<0){
            if (node.left==null){
                node.left=new Node(value);
                size++;
            }else{
                add2(node.left,value);
            }
        }else{
            if (node.right==null){
                node.right=new Node(value);
                size++;
            }else{
                add2(node.right,value);
            }
        }
    }



//    public void query(){
//        if (parent==null){
//        }
//    }

    public void printTree(){
        if (parent==null){
            System.out.println("The tree is empty");
        }else{
            printTree2(parent);
        }
    }

    private void printTree2(Node node){
       if (node.left!=null){
           printTree2(node.left);
       }
       System.out.println(node.value);
       if (node.right!=null){
           printTree2(node.right);
       }
    }


    public static void main(String[] args) {
        BST2<Integer> bst2=new BST2<>();
        bst2.add(42);
        bst2.add(37);
        bst2.add(12);
        bst2.add(18);
        bst2.add(6);
        bst2.add(11);
        bst2.add(5);
        bst2.printTree();
    }

}
