package javacode;

import Util.*;
import java.util.*;
/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        do {
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                var curr = queue.poll();
                if (curr != null) {
                    levelList.add(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            count = queue.size();
            if (!levelList.isEmpty()) {
                list.add(levelList);
            }
        } while (queue.size() != 0);
        return list;
    }
}
// @lc code=end
