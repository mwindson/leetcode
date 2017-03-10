package Problem101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/3/10.
 * https://leetcode.com/problems/path-sum-ii/?tab=Description
 */
public class Problem113 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1,-2,-3,1,3,-2,null,-1]");
        System.out.println(pathSum(tree, -1));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (root == null)
            return pathList;
        List<Integer> path = new ArrayList<>();
        findPath(root, pathList, path, sum);
        return pathList;
    }

    private static void findPath(TreeNode node, List<List<Integer>> pathList, List<Integer> path, int sum) {
        if (node.left == null && node.right == null && sum - node.val == 0) {
            path.add(node.val);
            pathList.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        } else {
            path.add(node.val);
            if (node.left != null) {
                findPath(node.left, pathList, path, sum - node.val);
            }
            if (node.right != null) {
                findPath(node.right, pathList, path, sum - node.val);
            }
            path.remove(path.size() - 1);
        }
    }
}
