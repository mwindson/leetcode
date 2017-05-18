package Problem101_200;

import Util.ListNode;

/**
 * Created by mwindson on 2017/5/18.
 * https://leetcode.com/problems/reorder-list/#/description
 */
public class Problem143 {
    public static void main(String[] args) {
        ListNode head = ListNode.parse(new int[]{1, 2, 3, 4, 5, 6});
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode slow = head, fast = head;
            ListNode helper = new ListNode(0);
            helper.next = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode preMiddle = slow;
            ListNode preCurrent = slow.next;
            while (preCurrent.next != null) {
                ListNode current = preCurrent.next;
                preCurrent.next = current.next;
                current.next = preMiddle.next;
                preMiddle.next = current;
            }

            ListNode p1 = head;
            ListNode p2 = preMiddle.next;
            while (p1 != preMiddle) {
                preMiddle.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2.next;
                p2 = preMiddle.next;
            }
        }
    }
}
