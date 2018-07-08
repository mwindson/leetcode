package nowcoder;

import Util.TreeNode;

public class P18 {
    /**
     * 二叉树的镜像
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
