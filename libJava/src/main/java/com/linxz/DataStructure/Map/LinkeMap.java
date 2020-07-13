package com.linxz.DataStructure.Map;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 09:36
 * version：v4.5.4
 * 描述：
 */
public class LinkeMap<K,V> implements Map<K,V>{

    private Node dumpHead;
    private int size;

    public LinkeMap(){
        dumpHead=new Node();
        size=0;
    }

    private  class Node{
        private K key;
        private V value;
        private Node next;

        private Node(K key,V value){
            this.key=key;
            this.value=value;
            this.next=null;
        }

        private Node(){}
    }

    @Override
    public void add(K key, V value) {
        if (contains(key)){
            set(key,value);
            return;
        }
        if (dumpHead==null){
            dumpHead=new Node(key,value);
            size++;
            return;
        }
        //遍历到最后一个结点，然后添加
        Node temp=dumpHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next= new Node(key,value);
        size++;
    }

    @Override
    public V remove(K key) {
        if (dumpHead.next==null){
             throw new IndexOutOfBoundsException("This LinkeMap is empty!!!");
        }
        Node temp=dumpHead;
        while (temp.next!=null){ //temp为要删除的结点的前一个结点
            if (temp.next.key.equals(key)){
                break;
            }
            temp = temp.next;
        }
        if (temp.next==null){
           return null;
        }
        V v=temp.next.value;
        temp.next=temp.next.next;
        size--;
        return v;
    }

    @Override
    public boolean contains(K key) {
        Node temp=dumpHead.next;
        while (temp!=null){
            if (temp.key.equals(key)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (dumpHead==null){
            throw new IndexOutOfBoundsException("This LinkeMap is empty!!!");
        }
        Node temp=dumpHead.next;
        while (temp!=null){
            if (temp.key.equals(key)){
                return temp.value;
            }
            temp=temp.next;
        }
        return null;
    }

    @Override
    public void set(K key, V value) {
        Node temp=dumpHead.next;
        while (temp!=null){
            if (temp.key.equals(key)){
               temp.value=value;
               break;
            }
            temp=temp.next;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        Node temp=dumpHead.next;
        while (temp != null) {
            sb.append(temp.key);
            sb.append(":");
            sb.append(temp.value);
            sb.append(",");
            temp = temp.next;
        }
        sb.append("] ");
        return sb.toString();
    }
}
