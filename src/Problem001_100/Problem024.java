package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/2/6.
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Problem024 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode list = ListNode.parse(nums);
        System.out.println(swapPairs(list));
    }

    public static ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
