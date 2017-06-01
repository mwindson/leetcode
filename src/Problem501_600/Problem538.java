package Problem501_600;

import java.util.Stack;

/**
 * Created by mwindson on 2017/6/1.
 * https://leetcode.com/problems/convert-bst-to-greater-tree/#/description
 */
public class Problem538 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[5,2,13]");
        System.out.println(convertBST(root));
    }

    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public static void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
