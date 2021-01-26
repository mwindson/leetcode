import Util.ListNode;

/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        var fast = fake;
        var slow = fake;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (curr != null) {
            var tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;
        }
        var node = fake;

        while (head != null && prev != null) {
            var tmp = head.next;
            node.next = head;
            node = node.next;
            node.next = prev;
            node = node.next;

            head = tmp;
            prev = prev.next;
        }
        if (head != null) {
            node.next = head;
        }
        head = fake.next;
    }
}
// @lc code=end
