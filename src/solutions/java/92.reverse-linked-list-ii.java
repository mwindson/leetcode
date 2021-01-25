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
        ListNode s = head;
        ListNode e = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
    }

}
// @lc code=end
