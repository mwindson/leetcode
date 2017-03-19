package Problem201_300;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/18.
 * https://leetcode.com/problems/reverse-linked-list/#/description
 */
public class Problem206 {
    public static void main(String[] args) {
        int[] nums = {};
        ListNode list = ListNode.parse(nums);
        System.out.println(reverseList(list));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = helper.next;
            helper.next = next;
        }
        return helper.next;
    }
}
