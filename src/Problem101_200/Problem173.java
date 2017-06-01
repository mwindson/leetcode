package Problem101_200;

import java.util.Stack;

/**
 * Created by mwindson on 2017/6/1.
 */
public class Problem173 {
    public class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            Stack<TreeNode> s = new Stack<>();
            while (root != null || !s.isEmpty()) {
                while (root != null) {
                    s.push(root);
                    root = root.right;
                }
                root = s.pop();
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return stack.pop().val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[4,2,5,1,3,null,6]");
    }
}
