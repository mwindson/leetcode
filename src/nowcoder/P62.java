package nowcoder;

import Util.TreeNode;

public class P62 {
    TreeNode ret;
    int count;

    TreeNode KthNode(TreeNode pRoot, int k) {
        ret = null;
        count = 0;
        if (k == 0) return ret;
        helper(pRoot, k);
        return ret;
    }

    private void helper(TreeNode node, int k) {
        if (node == null) return;
        helper(node.left, k);
        count++;
        if (count == k) {
            ret = node;
            return;
        }
        helper(node.right, k);
    }
}
