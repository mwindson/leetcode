package Problem101_200;

import Util.ListNode;

import java.util.List;

/**
 * Created by mwindson on 2017/3/13.
 * https://leetcode.com/problems/insertion-sort-list/#/description
 */
public class Problem147 {
    public static void main(String[] args) {
        int[] nums = {-6, -5, -4, -3, -2, -1};
        ListNode head = ListNode.parse(nums);
        System.out.println(insertionSortList(head));
    }

    //    public static ListNode insertionSortList(ListNode head) {
//        if (head == null)
//            return head;
//        ListNode sortList = new ListNode(head.val);
//        ListNode cur = head.next;
//        while (cur != null) {
//            sortList = inset(sortList, cur.val);
//            cur = cur.next;
//        }
//        return sortList;
//    }
//
//    private static ListNode inset(ListNode head, int num) {
//        ListNode result = head;
//        ListNode node = new ListNode(num);
//        if (num <= head.val) {
//            result = node;
//            result.next = head;
//        } else {
//            while (head != null) {
//                if (head.next == null) {
//                    head.next = node;
//                    break;
//                } else if (num <= head.next.val) {
//                    node.next = head.next;
//                    head.next = node;
//                    break;
//                }
//                head = head.next;
//            }
//        }
//        return result;
//    }
//    用helper帮助插入
//    One of the quotes is
//
//    For God's sake, don't try sorting a linked list during the interview
//    http://steve-yegge.blogspot.nl/2008/03/get-that-job-at-google.html
//
//    So it might be better to actually copy the values into an array and sort them there.
//    http://stackoverflow.com/questions/1525117/whats-the-fastest-algorithm-for-sorting-a-linked-list/1525419#1525419
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }
}
