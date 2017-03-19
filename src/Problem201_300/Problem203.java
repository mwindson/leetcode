package Problem201_300;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/17.
 * https://leetcode.com/problems/remove-linked-list-elements/#/description
 */
public class Problem203 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 1, 6, 2};
        ListNode head = ListNode.parse(nums);
        System.out.println(removeElements(head, 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(val + 1);
        helper.next = head;
        ListNode prev = helper;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = prev.next;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return helper.next;
    }
}
