package com.linxz.letcode.LinkedList;

public class 移除链表指定值元素 {

//    删除链表中等于给定值 val 的所有节点。
//    示例:
//
//    输入: 1->2->6->3->4->5->6, val = 6
//    输出: 1->2->3->4->5


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] nums){
            if (nums==null || nums.length==0)
                throw new IllegalArgumentException("nums cannot be null or empty");

            this.val=nums[0];
            ListNode cur=this;
            for (int i=1;i<nums.length;i++){
                cur.next= new ListNode(nums[i]);
                cur=cur.next;
            }
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

        public ListNode removeElements(ListNode head, int val) {
            //把左边与val相等的先删除
            while (head != null && head.val == val) {
                head = head.next;
            }

            if (head == null) {
                return null;
            }

            ListNode pre = head;
            while (pre.next != null) {
                if (pre.next.val == val) {
                    //需要删除该元素
                    ListNode delNode = pre.next;
                    pre.next = delNode.next;
                    delNode.next = null;
                } else {
                    pre = pre.next;
                }
            }
            return head;
        }


        public ListNode removeElements2(ListNode head, int val) {
            //给一个虚拟头结点
            ListNode dummyHead=new ListNode(-1);
            dummyHead.next=head;
            ListNode pre=dummyHead;
            while (pre.next!=null){
                if (pre.next.val==val){
                    ListNode delNode=pre.next;
                    pre.next=delNode.next;
                    delNode.next=null;
                }else{
                    pre=pre.next;
                }
            }
            return dummyHead.next;
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
//        ListNode listNode = new ListNode(1);
//        for (int i = 2; i <= 6; i++) {
//            solution.add(listNode, i);
//        }
//        solution.add(listNode, 3);
//        solution.printListNode(listNode);
//
//        solution.removeElements2(listNode,3);
//        solution.printListNode(listNode);

        //1->2->6->3->4->5->6

        int[] nums= new int[]{1,2,6,3,4,5,6};
        ListNode listNode2=new ListNode(nums);
        solution.printListNode(listNode2);
        System.out.println();

        solution.removeElements3(listNode2,6);
        solution.printListNode(listNode2);
        System.out.println();
    }


}