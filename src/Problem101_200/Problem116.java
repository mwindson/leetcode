package Problem101_200;

import Util.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/3/11.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/?tab=Description
 */
public class Problem116 {
    public static void main(String[] args) {
        TreeLinkNode root = TreeLinkNode.parse("[-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13]");
        connect(root);
        System.out.println(root);
    }

    //
//    public static void connect(TreeLinkNode root) {
//        if (root == null)
//            return;
//        Queue<TreeLinkNode> q = new ArrayDeque<>();
//        q.add(root);
//        int size = q.size();
//        while (!q.isEmpty()) {
//            for (int i = 0; i < size; i++) {
//                TreeLinkNode node = q.poll();
//                if (i < size - 1) {
//                    node.next = q.peek();
//                }
//                if (node.left != null && node.right != null) {
//                    q.add(node.left);
//                    q.add(node.right);
//                }
//            }
//            size = q.size();
//        }
//    }

    //  O(1) mem & O(n) time
    public static void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null) {
            TreeLinkNode cur = level_start;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }
}
