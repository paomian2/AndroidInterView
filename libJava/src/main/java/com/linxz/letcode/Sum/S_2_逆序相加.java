package com.linxz.letcode.Sum;

/**
 * @author Linxz
 * 创建日期：2021年07月20日 2:23 PM
 * version：
 * 描述：
 */
public class S_2_逆序相加 {

    public static void main(String[] args) {
        //l1 = [2,4,3], l2 = [5,6,4]
        //342 + 465 = 807   3420+465 = 3885
        S_2_逆序相加 逆序相加 = new S_2_逆序相加();
        S_2_逆序相加.ListNode node0= new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node1= new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node2=new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node3=new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node4=new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node5=new S_2_逆序相加.ListNode(9);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;


        S_2_逆序相加.ListNode node12= new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node22=new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node32=new S_2_逆序相加.ListNode(9);
        S_2_逆序相加.ListNode node42=new S_2_逆序相加.ListNode(9);
        node12.next=node22;
        node22.next=node32;
        node32.next=node42;

        S_2_逆序相加.ListNode resultNode = 逆序相加.addTwoNumbers2(node0,node12);
        System.out.println(resultNode);

    }


    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Size = 0;
        int l2Size = 0;
        ListNode l1LastNode = l1;
        while (l1LastNode!=null){
            l1LastNode=l1LastNode.next;
            l1Size++;
        }
        ListNode l2lastNode = l2;
        while (l2lastNode!=null){
            l2lastNode=l2lastNode.next;
            l2Size++;
        }
        int distance = l1Size - l2Size;
        if (distance>0){
            for (int i=0;i<distance;i++){
                ListNode secondLast = l2;
                while (secondLast.next!=null){
                    secondLast=secondLast.next;
                }
                secondLast.next=new ListNode(0);
            }
        }else if (distance<0){
            int  distanceReverse = Math.abs(distance);
            for (int i=0;i<distanceReverse;i++){
                ListNode secondLast = l1;
                while (secondLast.next!=null){
                    secondLast=secondLast.next;
                }
                secondLast.next=new ListNode(0);
            }
        }
        ListNode addLeft=l1;
        ListNode addRight=l2;
        ListNode resultNode=null;
        ListNode resultNextNode=null;
        boolean counting = true;
        int process = 0;
        while (counting){
            if (addLeft == null && addRight==null){
                //最高位进1
                resultNextNode.next = new ListNode(1);
                counting=false;
                continue;
            }
            int sumVal = addLeft.val+addRight.val+process;
            process=0;
            if (sumVal>=10){
                sumVal = sumVal%10;
                process=1;
            }
            if (resultNode==null){
                resultNode=new ListNode(sumVal);
                resultNextNode=resultNode;
            }else{
                resultNextNode.next = new ListNode(sumVal);
                resultNextNode = resultNextNode.next;
            }
            addLeft = addLeft.next;
            addRight = addRight.next;
            if (addLeft == null && addRight==null && process == 0){
                counting = false;
            }

        }
        return resultNode;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

} 