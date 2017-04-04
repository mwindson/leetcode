package Problem101_200;

/**
 * Created by mwindson on 2017/4/4.
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/#/description
 */
public class Problem106 {
    public static void main(String[] args) {
        int[] postorder = {3, 2, 6, 7, 5, 4, 1};
        int[] inorder = {3, 2, 1, 4, 6, 5, 7};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    private static TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val)
                inIndex = i;
        }
        node.left = helper(inorder, inStart, inIndex - 1, postorder, postEnd - inEnd + inIndex - 1);
        node.right = helper(inorder, inIndex + 1, inEnd, postorder, postEnd - 1);
        return node;
    }
}
