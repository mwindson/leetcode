package Problem501_600;

import java.util.Stack;

/**
 * Created by mwindson on 2017/5/25.
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/#/description
 */
public class Problem530 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,null,5,3]");
        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        int prev = -1;
        if (root == null) {
            return 0;
        } else {
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                min = prev < 0 ? min : Math.min(min, root.val - prev);
                prev = root.val;
                root = root.right;
            }
        }
        return min;
    }
}
