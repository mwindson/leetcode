package Problem600_700;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/6/13.
 * https://leetcode.com/problems/construct-string-from-binary-tree/#/description
 */
public class Problem606 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,null,4,5]");
        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.right == null && t.left == null) return "" + t.val;
        return "" + t.val + "(" + tree2str(t.left) + ")" + (t.right == null ? "" : "(" + tree2str(t.right) + ")");
    }
}
