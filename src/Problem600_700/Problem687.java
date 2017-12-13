package Problem600_700;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/10/5.
 * https://leetcode.com/problems/longest-univalue-path/description/
 */
public class Problem687 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,4,5,4,4,null,5]");
        System.out.println(longestUnivaluePath(root));
    }

    public static int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }

    private static int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0;
        int r = node.right != null ? dfs(node.right, res) : 0;
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);
    }
}
