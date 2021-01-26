import java.util.*;
/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
*/

import Util.ListNode;

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        var s = head;
        var e = head;
        var prev = fake;
        for (int i = 0; i < m - 1; i++) {
            s = s.next;
            prev = prev.next;
        }
        for (int i = 0; i < n - 1; i++) {
            e = e.next;
        }
        var succ = e.next;
        e.next = null;

        var curr = s;
        ListNode p = null;
        while (curr != null) {
            var tmp = curr.next;
            curr.next = p;
            p = curr;
            curr = tmp;
        }

        prev.next = p;
        if (s != null) {
            s.next = succ;
        }
        return fake.next;
    }
}
// @lc code=end
