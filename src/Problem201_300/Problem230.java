package Problem201_300;

/**
 * Created by mwindson on 2017/6/4.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/solutions
 */
public class Problem230 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1]");
        System.out.println(kthSmallest(root, 1));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
