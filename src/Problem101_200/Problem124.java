package Problem101_200;

/**
 * Created by mwindson on 2017/6/29.
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/#/description
 */
public class Problem124 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3]");
        System.out.println(maxPathSum(root));
    }

    static int maxValue = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxCount(root);
        return maxValue;
    }

    private static int maxCount(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxCount(node.left));
        int right = Math.max(0, maxCount(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
