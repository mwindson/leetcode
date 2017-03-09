package Problem101_200;

/**
 * Created by mwindson on 2017/3/9.
 * https://leetcode.com/problems/path-sum/?tab=Description
 */
public class Problem112 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(hasPathSum(tree, 18));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
