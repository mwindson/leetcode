package Problem201_300;

/**
 * Created by mwindson on 2017/6/2.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description
 */
public class Problem236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
