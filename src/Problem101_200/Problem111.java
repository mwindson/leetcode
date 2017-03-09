package Problem101_200;

/**
 * Created by mwindson on 2017/3/9.
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/?tab=Description
 */
public class Problem111 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1,2]");
        System.out.println(minDepth(tree));
    }

    public static int minDepth(TreeNode root) {
        return root == null ? 0 : countMinDepth(root);
    }

    private static int countMinDepth(TreeNode node) {
        int leftDepth = 0, rightDepth = 0;
        int minDepth = -1;
        if (node.left != null)
            leftDepth = countMinDepth(node.left) + 1;
        if (node.right != null)
            rightDepth = countMinDepth(node.right) + 1;
        if (node.left == null && node.right == null)
            return 1;
        if (leftDepth == 0) {
            minDepth = rightDepth;
        } else if (rightDepth == 0) {
            minDepth = leftDepth;
        } else {
            minDepth = Math.min(rightDepth, leftDepth);
        }
        return minDepth;
    }
}
