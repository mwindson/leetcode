package Problem101_200;

/**
 * Created by mwindson on 2017/4/4.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/#/description
 */
public class Problem105 {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5, 6, 7};
        int[] inorder = {3, 2, 1, 4, 6, 5, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0)
            return null;
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart > preorder.length || inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                inIndex = i;
            }
        }
        node.left = build(preorder, preStart + 1, inorder, inStart, inIndex - 1);
        node.right = build(preorder, preStart + inIndex - inStart + 1, inorder, inIndex + 1, inEnd);
        return node;
    }
}
