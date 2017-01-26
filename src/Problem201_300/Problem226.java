package Problem201_300;

/**
 * Created by mwindson on 2017/1/26.
 */
public class Problem226 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void buildTree() {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp;
        tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
