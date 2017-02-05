package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/2/5.
 * Question: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Problem021 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 7, 8, 12};
        int[] nums2 = {3, 4, 9, 11, 13};
        ListNode l1 = ListNode.parse(nums1);
        ListNode l2 = ListNode.parse(nums2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(Math.min(l1.val, l2.val));
        ListNode currentNode = root;
        if (l1.val <= l2.val) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null && l2 != null) {
                currentNode = insertNode(currentNode, l2.val);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                currentNode = insertNode(currentNode, l1.val);
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    currentNode = insertNode(currentNode, l1.val);
                    l1 = l1.next;
                } else {
                    currentNode = insertNode(currentNode, l2.val);
                    l2 = l2.next;
                }
            }
        }
        return root;
    }

    private static ListNode insertNode(ListNode l, int num) {
        ListNode node = new ListNode(num);
        l.next = node;
        l = node;
        return l;
    }
}
