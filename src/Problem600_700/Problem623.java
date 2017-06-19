package Problem600_700;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/6/19.
 * https://leetcode.com/problems/add-one-row-to-tree/#/description
 */
public class Problem623 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[4,2,6,3,1,5]");
        System.out.println(TreeNode.stringify(addOneRow(root, 0, 3)));
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode head = new TreeNode(v);
            head.left = root;
            return head;
        }
        helper(root, v, d, 0);
        return root;
    }

    private static void helper(TreeNode node, int v, int d, int depth) {
        if (depth == d - 1) {
            TreeNode left = new TreeNode(v);
            left.left = node.left;
            TreeNode right = new TreeNode(v);
            right.right = node.right;
            node.left = left;
            node.right = right;
        } else if (depth < d - 1) {
            if (node.left != null)
                helper(node.left, v, d, depth + 1);
            if (node.right != null)
                helper(node.right, v, d, depth + 1);
        }
    }
}
