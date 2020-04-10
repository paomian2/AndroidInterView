package com.linxz.letcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class 查询链表的中间结点 {

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    //如果有两个中间结点，则返回第二个中间结点。

    //输入：[1,2,3,4,5]
    //输出：此列表中的结点 3 (序列化形式：[3,4,5])
    //返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。

    //输入：[1,2,3,4,5,6]
    //输出：此列表中的结点 4 (序列化形式：[4,5,6])
    //由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] nums) {
            if (nums == null || nums.length == 0)
                throw new IllegalArgumentException("nums cannot be null or empty");

            this.val = nums[0];
            ListNode cur = this;
            for (int i = 1; i < nums.length; i++) {
                cur.next = new ListNode(nums[i]);
                cur = cur.next;
            }
        }
    }


    private static class Solution {
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


        public ListNode middleNode1(ListNode head) {
            if (head == null) {
                return null;
            }
            int index = getMiddleIndex(head);
            if (index == 0) {
                return head;
            }
            ListNode cur = head;
            int tempIndex = 0;
            while (tempIndex <= index - 1) {
                tempIndex++;
                cur = cur.next;
            }

            return cur;
        }

        public int getMiddleIndex(ListNode head) {
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count / 2;
        }

        /**
         * 遍历的时候先存起来
         * */
        public ListNode middleNode(ListNode head) {
            List<ListNode> list=new ArrayList<>();
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                ListNode tempNode=cur;
                list.add(tempNode);

                count++;
                cur = cur.next;
            }
            int index = count / 2;
            return list.get(index);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        ListNode listNode = new ListNode(nums);
        solution.printListNode(listNode);
        System.out.println();

        ListNode middleNode = solution.middleNode(listNode);
        solution.printListNode(middleNode);
        System.out.println(middleNode);
        System.out.println();

    }

}
