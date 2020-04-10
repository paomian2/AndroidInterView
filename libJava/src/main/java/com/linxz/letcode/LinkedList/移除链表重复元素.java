package com.linxz.letcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class 移除链表重复元素 {

//    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//    示例:
//
//    输入: 1->1->2->3->3
//    输出: 1->2->3


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    private static class Solution {


        public ListNode add(ListNode head, int val) {
            //找到最后一个元素(集next为null的元素)
            ListNode tailNode = head;
            while (tailNode.next != null) {
                tailNode = tailNode.next;
            }
            tailNode.next = new ListNode(val);
            return head;
        }


        /**
         * 输入: 1->1->2->3->3
         * 输出: 1->2->3
         */
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null){
                return null;
            }

            if (head.next==null){
                return head;
            }


            head.next=removeElements3(head.next,head.val);
            ListNode cur=head.next;
            if (cur!=null){
                cur=deleteDuplicates(cur);
            }


            return head;
        }

        /**
         * 递归实现
         */
        public ListNode removeElements3(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            head.next = removeElements3(head.next, val);
            if (head.val==val){
                return head.next;
            }else{
                return head;
            }
        }


        public void printListNode(ListNode head) {
            ListNode cur = head;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (cur != null) {
                sb.append(cur.val).append("->");
                cur = cur.next;
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        for (int i = 2; i <= 6; i++) {
            solution.add(listNode, i);
        }
        solution.add(listNode, 3);
        solution.printListNode(listNode);

        //solution.removeElements2(listNode,3);
        solution.printListNode(listNode);
    }


}