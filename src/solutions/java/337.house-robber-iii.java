import Problem501_600.TreeNode;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int rob(TreeNode root) {
        // f(i,0)=sum(max(f(x,1),f(x,0)))
        // f(i,1)=sum(f(x,0)) + i.val
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int first = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        int second = l[0] + r[0] + node.val;
        return new int[] { first, second };
    }
}
// @lc code=end
