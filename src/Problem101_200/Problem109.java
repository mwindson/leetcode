package Problem101_200;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/10.
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/?tab=Solutions
 */
public class Problem109 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.parse(nums);
        System.out.println(sortedListToBST(head));
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }

    private static TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail)
            return null;

        //使slow 位于中心位置
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head, slow);
        node.right = toBST(slow.next, tail);
        return node;
    }
}
