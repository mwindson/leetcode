package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/2/27.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/?tab=Description
 */
public class Problem083 {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        ListNode head = ListNode.parse(nums);
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode tmp = new ListNode(head.val);
        ListNode root = tmp;
        head = head.next;
        while (head != null) {
            if (tmp.val < head.val) {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
                head = head.next;
            } else {
                head = head.next;
            }
        }
        return root;
    }
}
