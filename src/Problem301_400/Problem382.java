package Problem301_400;

import Util.ListNode;

import java.util.Random;

/**
 * Created by mwindson on 2017/4/1.
 */
public class Problem382 {
    ListNode node;
    Random rnd;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Problem382(ListNode head) {
        node = head;
        rnd = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode h = node;
        int result = -1;
        int count = 0;
        while (h != null) {
            if (rnd.nextInt(++count) == 0) {
                result = h.val;
            }
            h = h.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.parse(new int[]{1});
        Problem382 obj = new Problem382(head);
        int param_1 = obj.getRandom();
        System.out.println(param_1);
    }
}
