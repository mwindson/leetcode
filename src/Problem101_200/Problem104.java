package Problem101_200;

import Util.*;

/**
 * Created by Administrator on 2016/12/4.
 */
public class Problem104 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1]");
        System.out.println(maxDepth(tree));
    }

    public static int maxDepth(TreeNode root) {
        int maxdepth = 0;
        if (root == null) return 0;
        return countDepth(root);
    }

    public static int countDepth(TreeNode node) {
        int leftDepth = 0, rightDepth = 0;
        if (node.left != null) {
            leftDepth = countDepth(node.left) + 1;
        }
        if (node.right != null) {
            rightDepth = countDepth(node.right) + 1;
        }
        if (node.left == null && node.right == null)
            return 1;
        return Math.max(leftDepth, rightDepth);
    }
}
