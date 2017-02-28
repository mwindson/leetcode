package Problem001_100;

import Util.ListNode;

/**
 * Created by mwindson on 2017/2/27.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?tab=Description
 */
public class Problem082 {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode list = ListNode.parse(nums);
        System.out.println(deleteDuplicates(list));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmpNode = null;
        ListNode root = tmpNode;
        int count = 0;
        int tmp = 0;
        while (head != null) {
            if (head.val == tmp) {
                count++;
            } else {
                if (count == 1) {
                    if (tmpNode == null) {
                        tmpNode = new ListNode(tmp);
                        root = tmpNode;
                    } else {
                        tmpNode.next = new ListNode(tmp);
                        tmpNode = tmpNode.next;
                    }
                }
                count = 1;
                tmp = head.val;
            }

            head = head.next;
        }
        if (count == 1) {
            if (tmpNode == null) {
                tmpNode = new ListNode(tmp);
                root = tmpNode;
            } else {
                tmpNode.next = new ListNode(tmp);
            }
        }
        return root;
    }
}
