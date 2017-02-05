package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/2/5.
 * Question: https://leetcode.com/problems/add-two-numbers/
 */
public class Problem002 {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 6};
        ListNode l1 = ListNode.parse(nums1);
        ListNode l2 = ListNode.parse(nums2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode node = root;
        int carryBit = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + carryBit;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carryBit;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carryBit;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (sum >= 10) {
                sum -= 10;
                carryBit = 1;
            } else {
                carryBit = 0;
            }
            ListNode tmp = new ListNode(sum);
            if (node == null) {
                root = tmp;
                node = tmp;
            } else {
                node.next = tmp;
                node = tmp;
            }
        }
        if(carryBit!=0){
            ListNode tmp = new ListNode(1);
            node.next = tmp;
            node = tmp;
        }
        return root;
    }
}
