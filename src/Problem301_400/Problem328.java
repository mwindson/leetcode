package Problem301_400;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/27.
 * https://leetcode.com/problems/odd-even-linked-list/#/description
 */
public class Problem328 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.parse(nums);
        ListNode.printListNode(oddEvenList(head));
    }

    // 分成两部分后再拼接
    public static ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
