package Problem101_200;

import Util.ListNode;

/**
 * Created by mwindson on 2017/3/14.
 * https://leetcode.com/problems/linked-list-cycle-ii/#/description
 */
public class Problem142 {
    // s:start to cycle start,c:cycle length,m:meeting node to cycle start
    // s+nc+m=2k, s+m=k => k=nc,s=k-m=>s=nc-m=(n-1)c+m-c
    // 因此循环起始点等于m-c长度和n-1个循环长度
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (slow != null && (fast != null && fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        // 两个新指针分别一步步从起始点和相遇点出发，最终会在循环起始点相会
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
