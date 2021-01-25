package Problem701_800;

import Util.ListNode;

import java.util.Arrays;

/**
 * Created by mwindson on 2017/12/11.
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 */
public class Problem725 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode root = ListNode.parse(nums);
        System.out.println(Arrays.toString(splitListToParts(root, 5)));
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            lists[i] = null;
        }
        ListNode curr = root;
        if (root == null) return lists;
        int len = 1;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        int partLen = len / k;
        ListNode node = root;
        for (int i = 0; i < k; i++) {
            int thisLen = i < len % k ? partLen + 1 : partLen;
            if (thisLen == 0) {
                lists[i] = null;
            } else {
                ListNode start = node;
                ListNode end = node;
                for (int j = 0; j < thisLen - 1; j += 1) {
                    end = end.next;
                }
                node = end.next;
                end.next = null;
                lists[i] = start;
            }
        }
        return lists;
    }
}
