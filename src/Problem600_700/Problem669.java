package Problem600_700;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/9/4.
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
 */
public class Problem669 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[3,0,4,null,2,null,null,1]");
        int L = 1, R = 3;
        System.out.println(TreeNode.stringify(trimBST(root, 3, 4)));
    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        // need not to trim
        if (root.val >= L && root.val <= R) {
            if (root.left != null) {
                root.left = trimBST(root.left, L, R);
            }
            if (root.right != null) {
                root.right = trimBST(root.right, L, R);
            }
        } else if (root.val < L) {
            // left subtree need to trim
            root = trimBST(root.right, L, R);
        } else {
            root = trimBST(root.left, L, R);
        }
        return root;
    }
}
