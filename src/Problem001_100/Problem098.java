package Problem001_100;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * @ tag tree | dfs
 */
public class Problem098 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[10,5,15,null,null,6,20]");
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> nodes = new ArrayList<>();
        dfs(nodes, root);
        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) <= nodes.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(List<Integer> nodes, TreeNode root) {
        if (root.left != null)
            dfs(nodes, root.left);
        nodes.add(root.val);
        if (root.right != null)
            dfs(nodes, root.right);
    }

}
