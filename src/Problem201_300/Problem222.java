package Problem201_300;

/**
 * Created by mwindson on 2017/6/8.
 * https://leetcode.com/problems/count-complete-tree-nodes/#/solutions
 */
public class Problem222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}