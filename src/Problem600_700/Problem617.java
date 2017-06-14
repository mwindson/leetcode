package Problem600_700;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/6/13.
 * https://leetcode.com/problems/merge-two-binary-trees/#/solutions
 */
public class Problem617 {
    public static void main(String[] args) {
        TreeNode t1 = TreeNode.parse("[1,2,3,4]");
        TreeNode t2 = TreeNode.parse("[2,1,3,null,5,null,4]");
        System.out.println(TreeNode.stringify(mergeTrees(t1, t2)));
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode node = new TreeNode(val);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }
}
