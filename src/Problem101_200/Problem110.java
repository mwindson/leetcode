package Problem101_200;

/**
 * Created by mwindson on 2017/3/10.
 * https://leetcode.com/problems/balanced-binary-tree/?tab=Description
 */
public class Problem110 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,7,3,4,8,null,null,null,5]");
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return countDepth(root) != -1;
    }

    private static int countDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = countDepth(node.left);
        if (leftDepth == -1)
            return -1;
        int rightDepth = countDepth(node.right);
        if (rightDepth == -1)
            return -1;
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
