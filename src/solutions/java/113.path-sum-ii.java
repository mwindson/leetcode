import java.util.*;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum, new ArrayList<>());
        return res;
    }

    void dfs(TreeNode node, int sum, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && sum + node.val == targetSum) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, sum + node.val, targetSum, path);
        dfs(node.right, sum + node.val, targetSum, path);
        path.remove(path.size() - 1);
    }
}
// @lc code=end
