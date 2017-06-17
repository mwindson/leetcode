package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/6/16.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/#/description
 */
public class Problem025 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode root = ListNode.parse(nums);
        ListNode result = reverseKGroup(root, 5);
        System.out.println(result);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (node != null && len < k) {
            node = node.next;
            len++;
        }
        ListNode helper = new ListNode(0);
        if (len < k) {
            return head;
        } else {
            ListNode curr = head.next;
            helper.next = head;
            int count = k - 1;
            while (count > 0) {
                head.next = head.next.next;
                curr.next = helper.next;
                helper.next = curr;
                curr = head.next;
                count--;
            }
            head.next = reverseKGroup(head.next, k);
        }
        return helper.next;
    }
}
