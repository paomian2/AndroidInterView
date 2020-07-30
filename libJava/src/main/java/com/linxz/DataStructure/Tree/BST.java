package com.linxz.DataStructure.Tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Linxz
 * 创建日期：2020年06月28日 14:19
 * version：v4.5.4
 * 描述：二分搜索树(Binary Search Tree)，左边结点小于父结点，父结点小于右边结点(不会有相等的情况，真正情况下可以把等放左结点或者右结点)
 *      E有可比性，所以要继承Comparable
 *
 *      局限性：最差的情况下变成普通链表一样，递归很消耗性能
 *
 *      时间复杂度 O(h)  平均O(logn) 最差O(n)  全部结点都只有右结点的时候退化成单链表的结构
 */
public class BST<E extends Comparable<E>> {


    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public void add(E e){
        Node node=new Node(e);
        if (root==null){
            root=node;
            size++;
        }else{
            add(root,e);
        }
    }


    private void add(Node root,E e){
        if (root.e.compareTo(e)>0){
            //左结点
            if (root.left==null){
                root.left= new Node(e);
                size++;
            }else {
                add(root.left,e);
            }
        }
        //二分搜索树不保存重复的元素
//        else {
//            //右结点
//            if (root.right==null){
//                root.right=new Node(e);
//                size++;
//            }else{
//                add(root.right,e);
//            }
//        }

        else if (root.e.compareTo(e)<0){
            //右结点
            if (root.right==null){
                root.right=new Node(e);
                size++;
            }else{
                add(root.right,e);
            }
        }

    }


    //------改进写法---------------
    public void add2(E e){
        root=add2(root,e);
    }

    private Node add2(Node node,E e){
        if (node==null){
            return new Node(e);
        }
        if (e.compareTo(node.e)<0){
            node.left=add2(node.left,e);
        }else if (e.compareTo(node.e)>0){
            node.right=add2(node.right,e);
        }
        return node;
    }


    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if (node==null){
            return false;
        }
        //判断是否小于左子树
        if (e.compareTo(node.e)<0){
            return contains(node.left, e);
        }
        //判断右子树
        else if (e.compareTo(node.e)>0){
            return contains(node.right, e);
        }
        //直接等于结点
        return e.compareTo(node.e) == 0;
    }


    //遍历，中序遍历(先左边、结点、右边)，排序后的结果，所以二分搜索树也叫排序树
    public List<E> queryList(){
        List<E> list=new ArrayList<>();
        queryList(root,list);
        return list;
    }

    private void queryList(Node node,List<E> list){
        if(node==null)
            return;
        //遍历左子树
        queryList(node.left,list);
        //结点
        System.out.println(node.e);
        list.add(node.e);
        //遍历右子树
        queryList(node.right,list);
    }


    //前序遍历,先结点，左子树，右子树
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //后序遍历(先处理完孩子，再处理结点)，使用场景：手动内存释放
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node==null)
            return;
        //左子树
        postOrder(node.left);
        //右子树
        postOrder(node.right);
        //结点
        System.out.println(node.e);
    }


    //非递归方式遍历，先将结点放入栈，出栈，然后依次将右子树、左子树入栈,然后出栈(由栈的特效知道右子树、左子树出栈的顺序相反)
    //左子树出栈的时候将其右左子树入栈出栈
    //总而言之，结点栈然后出栈，出栈的时候将其右子树、左子树依次入栈

    public void preOrderNR(){
        Stack<Node> nodeArrayStack=new Stack<>();
        nodeArrayStack.push(root);
        while (!nodeArrayStack.isEmpty()){
            //栈顶出栈
            Node curNode=nodeArrayStack.pop();
            System.out.println(curNode.e);
            //右、左子树入栈
            if (curNode.right!=null)
                nodeArrayStack.push(curNode.right);
            if (curNode.left!=null)
                nodeArrayStack.push(curNode.left);
        }
    }


    //层序遍历/广度优先，一层一层往下走。
    //使用队列实现。先进先出。首先结点入队，结点出队。左、右子树入队。左子树出队(左子树左右子树入队),右子树出队
    //总而言之，结点出队的时候，将期左右子树入队。
    public void preOrderNR2(){
        Queue<Node> nodeQueue=new LinkedList<>();
        //结点入队
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            //队首出队
            Node curNode=nodeQueue.remove();
            System.out.println(curNode.e);
            //左右子树入队
            if (curNode.left!=null)
                nodeQueue.add(curNode.left);
            if (curNode.right!=null)
                nodeQueue.add(curNode.right);
        }
    }

    //搜索最小值
    public E minValue(){
        if (size==0)
            throw new IndexOutOfBoundsException("this is a empty bse");
        return minValue(root).e;
    }

    private Node minValue(Node node){
        if (node==null)
            return null;
        if (node.left==null)
            return node;
        return minValue(node.left);
    }


    //删除最小值
    public void deleteMin(){
        deleteLeftNode(root);
    }

    private void deleteLeftNode(Node node){
        if (node==null)
            return;
        if (node.left==null && node.right==null)
            //当前Node就是最小值,并且Node结点没有右子树，可以直接删除
            node=null;
        else if (node.left == null)
            //当前Node就是最小值，并且Node结点右子树，需要将右子树接到当前Node上
            node=node.right;
        else if (node.left.left==null && node.left.right==null)
            //node的左子树是最小值。判断这棵左子树结点有没有右子树，如果没有可以直接删除，如果有则要将右子树接上去
            node.left=null;
        else if (node.left.left==null)
            node.left=node.left.right;
        else
            deleteLeftNode(node.left);
    }

    //删除最大值
    public void deleteMax(){
        deleteRightNode(root);
    }

    private void deleteRightNode(Node node){
        if (node==null)
            return;
        if (node.right==null && node.left==null)
            //当前Node就是最大值,并且没有左子树
            node=null;
        else if (node.right==null)
            //当前Node就是最大值,并且有左子树
            node=node.left;
        else if (node.right.right==null)
            //当前Node的右子树是最大值,并且
            node.right=null;
        else deleteRightNode(node.right);
    }



    //删除最小值
    public E removeMin(){
        E minValue=minValue();
        removeMin(root);
        return minValue;
    }

    private Node removeMin(Node node){
        if (node.left==null){
            //当前Node就是最小值
            //不管Node的右子树是否为null,都将右子树接到左子树上面
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }else{
            node.left=removeMin(node.left);
            return node;
        }
    }


    public void remove(E e){
        root=remove(root,e);
    }


    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e)==0){
            //目标结点为当前结点
            //如果没有左子树,
            if (node.left==null){
               Node rightNode=node.right;
               node.right=null;
               size--;
               return rightNode;
            }
            //如果没有右结点
            if (node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //左右子树都不为空，删除该结点后，需要在右子树中寻找最小的结点替代
            Node successor=minValue(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
        else if (e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }
        else{
            node.right=remove(node.right,e);
            return node;
        }

    }

    //搜索最大
    private Node maxNode(Node node){
        if (node.right==null)
            return node;
        return maxNode(node.right);
    }

    public void printTree(){
        if (root==null){
            System.out.println("This is a empty tree");
        }else{
            printTree(root);
        }
    }

    private void printTree(Node root){
        if (root.left!=null){
            printTree(root.left);
        }

        System.out.println(root.e);

        if (root.right!=null){
            printTree(root.right);
        }
    }

}
