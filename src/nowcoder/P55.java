package nowcoder;

import Util.ListNode;

public class P55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead, slow = pHead;
        while (fast != null) {
            if (fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null) return null;
        ListNode entry = pHead;
        while (entry != null && slow != null && entry != slow) {
            slow = slow.next;
            entry = entry.next;
        }
        return entry;
    }
}
