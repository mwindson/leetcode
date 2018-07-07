package nowcoder;

import Util.ListNode;

import java.util.ArrayList;

public class P3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            list = printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
