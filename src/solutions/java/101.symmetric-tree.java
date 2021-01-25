package javasolution;

import Util.TreeNode;
/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left, root.right);
    }

    boolean check(TreeNode a, TreeNode b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return a == null;
        }

        return a.val == b.val && check(a.left, b.right) && check(a.right, b.left);
    }
}
// @lc code=end
