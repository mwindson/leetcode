package nowcoder;

import Util.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树和为某一个值的路径
 * 从根节点到叶节点
 */
public class P23 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[10,5,12,4,7]");
        int target = 22;
        System.out.println(new P23().FindPath(root, target));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        ArrayList<Integer> list = new ArrayList<>();
        helper(ret, list, 0, root, target);
        return ret;
    }

    private void helper(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, int sum, TreeNode node, int target) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                paths.add(new ArrayList<>(path));
            }
        } else {
            if (node.left != null) {
                helper(paths, path, sum + node.val, node.left, target);
            }
            if (node.right != null) {
                helper(paths, path, sum + node.val, node.right, target);
            }
        }
        path.remove(path.size() - 1);
    }
}
