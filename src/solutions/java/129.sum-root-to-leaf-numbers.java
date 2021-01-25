package javacode;

import Util.*;
/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    int helper(TreeNode node, int prev) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return prev * 10 + node.val;
        }
        return helper(node.left, prev * 10 + node.val) + helper(node.right, prev * 10 + node.val);
    }
}
// @lc code=end
