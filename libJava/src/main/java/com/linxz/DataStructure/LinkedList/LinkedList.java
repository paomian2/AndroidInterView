package com.linxz.DataStructure.LinkedList;


/**
 * 虚拟头节点
 */
public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private Node prev;
    private int size;

    public LinkedList(){
        dummyHead=new Node();
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index out of size.");

        Node tempPrev = dummyHead;
        for (int i = 0; i < index; i++) {
            tempPrev = tempPrev.next;
        }
        tempPrev.next = new Node(e, tempPrev.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Illegal index out of size.");

        Node cur=dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Illegal index out of size.");

        Node cur=dummyHead.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }


    public boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Illegal index out of size.");

        Node tempPrev = dummyHead;
        for (int i = 0; i < index; i++) {
            tempPrev = tempPrev.next;
        }

        Node delNode=tempPrev.next;
        tempPrev.next=delNode.next;
        delNode.next=null;
        size--;
        return delNode.e;
    }

    public boolean remove(E e){
        if (size==0){
            return false;
        }
        Node tempPrev = dummyHead;
        boolean searchSuccess=false;
        for (int i = 0; i < size; i++) {
            if (e.equals(tempPrev.next)){
                searchSuccess=true;
                break;
            }else{
                tempPrev = tempPrev.next;
            }
        }

        if (searchSuccess){
            Node delNode=tempPrev.next;
            tempPrev.next=delNode.next;
            delNode.next=null;
            size--;
        }

        return false;
    }


    //
    public void removeElement(E e){
        Node prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.e.equals(e))
                break;
            prev=prev.next;
        }

        if (prev.next!=null){ //如果查询到结果的话，那么要删除的结点的前一个结点的子结点肯定不为null，也就要要删除的结点肯定不为空
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList: size = %d\n", size));
        for (Node cur=dummyHead.next; cur!=null; cur=cur.next) {
            sb.append(cur).append("->");
        }
        sb.append("NULL");
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int i=0;i<10;i++){
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        System.out.println();

        System.out.println(linkedList.remove(1));
        System.out.println(linkedList);
        System.out.println();
    }
}