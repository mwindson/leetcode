package Problem101_200;

import Util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/3/8.
 * https://leetcode.com/problems/binary-tree-level-order-traversal/?tab=Solutions
 */
public class Problem103 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[3,9,20,null,null,15,7]");
        System.out.println(zigzagLevelOrder(tree));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int size = 1;
        boolean order = true;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if (n.left != null)
                    q.offer(n.left);
                if (n.right != null)
                    q.offer(n.right);
            }
            list.add(tmp);
            size = q.size();
            order = !order;
        }
        return list;
    }
}
