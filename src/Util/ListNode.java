package Util;

/**
 * Created by mwindson on 2017/1/27.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode parse(int[] nums) {
        ListNode root = new ListNode(nums[0]);
        ListNode currentNode = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            currentNode.next = node;
            currentNode = node;
        }
        return root;
    }
}
