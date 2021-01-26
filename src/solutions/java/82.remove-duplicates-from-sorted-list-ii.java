import Util.ListNode;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = new ListNode(0);
        var curr = head;
        var pre = h;
        while (curr != null) {
            boolean duplicated = false;
            while (curr.next != null && curr.val == curr.next.val) {
                duplicated = true;
                curr = curr.next;
            }
            if (curr.next == null && duplicated) {
                pre.next = null;
            } else if (!duplicated) {
                pre.next = curr;
                pre = pre.next;
            }
            curr = curr.next;
        }
        return h.next;
    }
}
// @lc code=end
