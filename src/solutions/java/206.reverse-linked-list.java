/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        var curr = head;
        ListNode prev = null;
        while (curr != null) {
            var tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
// @lc code=end
