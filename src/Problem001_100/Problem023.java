package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/7/4.
 * https://leetcode.com/problems/merge-k-sorted-lists/#/description
 */
public class Problem023 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{ListNode.parse(new int[]{1, 3, 5, 7}), ListNode.parse(new int[]{2, 4, 5, 13}), ListNode.parse(new int[]{8, 10, 11, 12})};
        ListNode.printListNode(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }

    private static ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int middle = (end - start) / 2 + start;
        ListNode left = helper(lists, start, middle);
        ListNode right = helper(lists, middle + 1, end);
        return merge(left, right);
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
