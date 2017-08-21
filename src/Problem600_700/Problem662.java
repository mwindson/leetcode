package Problem600_700;

import Util.TreeNode;

import java.util.*;

/**
 * Created by mwindson on 2017/8/21.
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 */
public class Problem662 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2]");
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    // use two arrays (start[] and end[]) to record the the indices of the leftmost node and rightmost node in each level
    public static int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * order, start, end);
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
