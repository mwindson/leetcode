import java.util.List;

import Util.ListNode;

/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            ListNode res = mergeTwoLists(l1.next, l2);
            l1.next = res;
            return l1;
        } else {
            ListNode res = mergeTwoLists(l1, l2.next);
            l2.next = res;
            return l2;
        }
    }

}
// @lc code=end
