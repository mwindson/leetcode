import Util.ListNode;

/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        var l = less;
        var m = more;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                m.next = head;
                m = m.next;
            }
            head = head.next;
        }
        l.next = more.next;
        m.next = null;
        return less.next;
    }
}
// @lc code=end
