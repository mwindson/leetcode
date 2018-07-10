package nowcoder;

import Util.TreeNode;

public class P58 {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || pRoot.left == null && pRoot.right == null || pRoot.left != null && pRoot.right != null && isSame(pRoot.left, pRoot.right);
    }

    boolean isSame(TreeNode a, TreeNode b) {
        return a == null && b == null || a != null && b != null && a.val == b.val && isSame(a.left, b.right) && isSame(a.right, b.left);
    }
}
