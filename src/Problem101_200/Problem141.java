package Problem101_200;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/14.
 * https://leetcode.com/problems/linked-list-cycle/#/description
 */
public class Problem141 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = ListNode.parse(nums);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && (fast != null && fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
