package nowcoder;

import Util.ListNode;

public class P15 {
    public ListNode ReverseList(ListNode head) {
        ListNode helper = new ListNode(0);
        while (head != null) {
            ListNode tmp = head.next;
            head.next = helper.next;
            helper.next = head;
            head = tmp;
        }
        return helper.next;
    }
}
