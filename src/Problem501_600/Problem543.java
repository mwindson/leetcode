package Problem501_600;

/**
 * Created by mwindson on 2017/3/26.
 * https://leetcode.com/problems/diameter-of-binary-tree/#/description
 */
public class Problem543 {
    static int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1]");
        System.out.println(diameterOfBinaryTree(root));
    }

    // 提交代码去掉static才能AC
    public static int diameterOfBinaryTree(TreeNode root) {
        int rootLen = 0;
        if (root == null)
            return rootLen;
        rootLen = calDiameter(root);
        return rootLen > diameter ? rootLen : diameter;
    }

    // nums[0]为最大高度，nums[1]为最大直径
    private static int calDiameter(TreeNode node) {
        int leftLen = 0, rightLen = 0;
        if (node.left != null) {
            leftLen = calDiameter(node.left) + 1;
        }
        if (node.right != null)
            rightLen = calDiameter(node.right) + 1;
        if (node.left == null && node.right == null)
            return 0;
        if (leftLen + rightLen > diameter)
            diameter = leftLen + rightLen;
        return Math.max(leftLen, rightLen);
    }
}
