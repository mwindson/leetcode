package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/2/5.
 * Question: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem019 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode root = ListNode.parse(nums);
        System.out.println(removeNthFromEnd(root, 4));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (n > 0) {
            l2 = l2.next;
            n--;
        }
        if (l2 == null) {
            head = head.next;
            return head;
        }
        while (l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = l1.next.next;
        return head;
    }
}
