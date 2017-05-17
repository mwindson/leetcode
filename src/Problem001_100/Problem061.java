package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/5/17.
 * https://leetcode.com/problems/rotate-list/#/description
 */
public class Problem061 {
    public static void main(String[] args) {
        ListNode head = ListNode.parse(new int[]{1, 2});
        System.out.println(rotateRight(head, 5));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode slow = helper.next, fast = helper.next;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        k %= count;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) return helper.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = helper.next;
        helper.next = slow.next;
        slow.next = null;
        return helper.next;
    }
}
