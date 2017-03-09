package Problem101_200;

import Util.*;

import java.util.*;

/**
 * Created by mwindson on 2017/3/8.
 * https://leetcode.com/problems/symmetric-tree/?tab=Description
 */
public class Problem101 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1,2,2,null,3,null,3]");
        System.out.println(isSymmetric(tree));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
