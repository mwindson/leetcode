package Problem401_500;

/**
 * Created by mwindson on 2017/6/1.
 * https://leetcode.com/problems/delete-node-in-a-bst/#/description
 */
public class Problem450 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[7,4,8,2,6,null,null,null,3,5]");
        System.out.println(deleteNode(root, 4));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
