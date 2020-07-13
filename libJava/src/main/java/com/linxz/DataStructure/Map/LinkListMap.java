package com.linxz.DataStructure.Map;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 10:52
 * version：v4.5.4
 * 描述：新写法
 */
public class LinkListMap<K,V> implements Map<K,V> {

    private  class Node{
        private K key;
        private V value;
        private Node next;

        private Node(K key,V value){
            this.key=key;
            this.value=value;
            this.next=null;
        }

        public Node(K key, V value,Node next) {
            this.key = key;
            this.value=value;
            this.next = next;
        }


        private Node(){}

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkListMap(){
        dummyHead=new Node();
    }


    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null ? null : node.value;
    }

    @Override
    public void add(K key, V value) {
        Node node=getNode(key);
        if (node==null){  //如果Node为null证明Node已经是最后一个结点 新增结点
           dummyHead.next=new Node(key,value,dummyHead.next);
           size++;
        }else{ //修改结点
            node.value=value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node=getNode(key);
        if (node==null)
            return;
        node.value=value;
    }


    @Override
    public V remove(K key) {
        Node prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.key.equals(key))
                break;
            prev=prev.next;
        }
        if (prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
            return delNode.value;
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        Node temp=dummyHead.next;
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
