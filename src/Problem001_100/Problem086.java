package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/24.
 * https://leetcode.com/problems/partition-list/#/description
 */
public class Problem086 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode list = ListNode.parse(nums);
        System.out.println(partition(list, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0), node2 = new ListNode(0);
        ListNode p1 = node1, p2 = node2;
        while (head != null) {
            if (head.val < x)
                p1 = p1.next = head;
            else
                p2 = p2.next = head;
            head = head.next;
        }
        p2.next = null;
        p1.next = node2.next;
        return node1.next;
    }
}
