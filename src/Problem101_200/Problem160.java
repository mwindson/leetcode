package Problem101_200;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/19.
 * https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 */
public class Problem160 {
    public static void main(String[] args) {
        // 样例不对
        int[] numA = {1, 2, 7, 8, 9};
        int[] numB = {3, 4, 5, 6, 7, 8, 9};
        ListNode headA = ListNode.parse(numA);
        ListNode headB = ListNode.parse(numB);
        System.out.println(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode node = headA;
        while (node != null) {
            node = node.next;
            lengthA++;
        }
        node = headB;
        while (node != null) {
            node = node.next;
            lengthB++;
        }
        if (lengthA >= lengthB) {
            while (lengthB < lengthA) {
                headA = headA.next;
                lengthA--;
            }
        } else {
            while (lengthA < lengthB) {
                headB = headB.next;
                lengthB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
