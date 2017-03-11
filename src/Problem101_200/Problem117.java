package Problem101_200;

import Util.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/3/11.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/?tab=Description
 */
public class Problem117 {
    public static void main(String[] args) {
        TreeLinkNode root = TreeLinkNode.parse("[1]");
        connect(root);
        System.out.println(root);
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null) {
            TreeLinkNode cur = level_start;
            while (cur != null) {
                if (cur.left != null) {
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    } else {
                        TreeLinkNode next = cur.next;
                        while (next != null && (next.left == null && next.right == null)) {
                            next = next.next;
                        }
                        if (next != null) {
                            if (next.left != null)
                                cur.left.next = next.left;
                            else
                                cur.left.next = next.right;
                        }
                    }
                }
                if (cur.right != null) {
                    TreeLinkNode next = cur.next;
                    while (next != null && (next.left == null && next.right == null)) {
                        next = next.next;
                    }
                    if (next != null) {
                        if (next.left != null)
                            cur.right.next = next.left;
                        else
                            cur.right.next = next.right;
                    }
                }
                cur = cur.next;
            }
            while (level_start != null && (level_start.left == null && level_start.right == null)) {
                level_start = level_start.next;
            }
            if (level_start != null) {
                if (level_start.left != null)
                    level_start = level_start.left;
                else
                    level_start = level_start.right;
            }
        }
    }
}
