package Problem101_200;

/**
 * Created by mwindson on 2017/3/10.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?tab=Description
 */
public class Problem114 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.parse("[1,2,5,3,4,null,6]");
        flatten(tree);
        System.out.println(tree);
    }

    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        TreeNode rightestNode = root;
        if (root.right != null)
            flatten(root.right);
        while (rightestNode.right != null) {
            rightestNode = rightestNode.right;
        }
        if (root.left != null) {
            rightestNode.right = root.left;
            root.left = null;
            flatten(rightestNode.right);
        }
    }
}
