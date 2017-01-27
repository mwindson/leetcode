package Problem201_300;

import Util.ListNode;

/**
 * Created by mwindson on 2017/1/27.
 * Question: https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Problem237 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode root = ListNode.parse(nums);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
