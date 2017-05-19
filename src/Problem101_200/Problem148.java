package Problem101_200;

import Util.ListNode;

/**
 * Created by mwindson on 2017/5/19.
 * https://leetcode.com/problems/sort-list/#/solutions
 */
public class Problem148 {
    public static void main(String[] args) {
        ListNode head = ListNode.parse(new int[]{1, 3, 7, 6, 8, 5, 4});
        ListNode res = sortList(head);
        System.out.println(res);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // step 1: split 2 halves
        ListNode slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // step 2: sort each
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(slow);

        // step 3: merge 2 halves
        return mergeList(p1, p2);
    }

    static ListNode mergeList(ListNode p1, ListNode p2) {
        ListNode l = new ListNode(0), p = l;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null)
            p.next = p1;
        if (p2 != null)
            p.next = p2;
        return l.next;
    }
}
