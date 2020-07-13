package com.linxz.DataStructure.Map;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 11:23
 * version：v4.5.4
 * 描述：
 *
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {


    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;

        private Node(K key,V value){
            this.key=key;
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    private Node root;
    private int size;

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
       return getNode(root,key).value;
    }

    @Override
    public void set(K key, V value) {
        Node node=getNode(root,key);
        if (node!=null){
            node.value=value;
        }
    }

    public void add(K key, V value){
        Node node=new Node(key,value);
        if (root==null){
            root=node;
            size++;
        }else{
            add(root,key,value);
        }
    }


    private Node getNode(Node node,K key){
        if (node==null){
            return null;
        }
        //判断是否小于左子树
        if (key.compareTo(node.key)<0){
            return getNode(node.left, key);
        }
        //判断右子树
        else if (key.compareTo(node.key)>0){
            return getNode(node.right, key);
        }
        //直接等于结点
        return key.compareTo(node.key) == 0 ? node : null;
    }


    private void add(Node root,K key,V value){
        if (root.key.compareTo(key)>0){
            //左结点
            if (root.left==null){
                root.left= new Node(key,value);
                size++;
            }else {
                add(root.left,key,value);
            }
        }
        else if (root.key.compareTo(key)<0){
            //右结点
            if (root.right==null){
                root.right=new Node(key,value);
                size++;
            }else{
                add(root.right,key,value);
            }
        }
        else if (root.key.compareTo(key)==0){
            //修改该结点
            root.value=value;
        }
    }


    @Override
    public V remove(K key) {
        Node node=getNode(root,key);
        if (node!=null){
            root=remove(root,key);
            return node.value;
        }
        return null;
    }


    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key)==0){
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
        else if (key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }
        else{
            node.right=remove(node.right,key);
            return node;
        }

    }


    private Node minValue(Node node){
        if (node==null)
            return null;
        if (node.left==null)
            return node;
        return minValue(node.left);
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


    public void printTree(Node node) {
        if (node.left!=null){
            printTree(node.left);
        }

        System.out.print(node.key+":"+node.value+",");

        if (node.right!=null){
            printTree(node.right);
        }
    }

    @Override
    public String toString() {
        System.out.print("[ ");
        printTree(root);
        System.out.print(" ]");
        System.out.println();
        return super.toString();
    }
}
