package nowcoder;

import Util.ListNode;

public class P16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode node = null;
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node = list1;
                node.next = Merge(list1.next, list2);
            } else {
                node = list2;
                node.next = Merge(list1, list2.next);
            }
        } else if (list1 != null) {
            node = list1;
        } else if (list2 != null) {
            node = list2;
        }
        return node;
    }
}
