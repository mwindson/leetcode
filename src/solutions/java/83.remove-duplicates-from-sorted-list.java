import Util.ListNode;

/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        var curr = head;
        var prev = fake;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            prev.next = curr;
            prev = prev.next;
            curr = curr.next;
        }
        return fake.next;
    }
}
// @lc code=end
