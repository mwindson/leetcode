package nowcoder;

import Util.ListNode;

public class P56 {
    public static void main(String[] args) {
        ListNode root = ListNode.parse(new int[]{1, 2, 3, 3, 4, 5});
        System.out.println(new P56().deleteDuplication(root));
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode helper = new ListNode(0);
        helper.next = pHead;
        ListNode prev = helper;
        ListNode node = pHead;
        while (node != null) {
            boolean isSame = false;
            while (node.next != null && node.val == node.next.val) {
                isSame = true;
                node = node.next;
            }
            if (isSame) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return helper.next;
    }
}
