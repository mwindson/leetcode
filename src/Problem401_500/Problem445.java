package Problem401_500;

import Util.ListNode;

import java.util.Stack;

/**
 * Created by mwindson on 2017/5/17.
 * https://leetcode.com/problems/add-two-numbers-ii/#/description
 */
public class Problem445 {
    public static void main(String[] args) {
        int[] nums1 = {7, 2, 4, 3}, nums2 = {5, 6, 4};
        ListNode l1 = ListNode.parse(nums1);
        ListNode l2 = ListNode.parse(nums2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode helper = new ListNode(0);
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val) + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            node.next = helper.next;
            helper.next = node;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = helper.next;
            helper.next = node;
        }
        return helper.next;
    }
}
