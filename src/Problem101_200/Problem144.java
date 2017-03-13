package Problem101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mwindson on 2017/3/13.
 * https://leetcode.com/problems/binary-tree-preorder-traversal/#/description
 */
public class Problem144 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,4,5,6,7]");
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        if (root == null)
            return preorderList;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            preorderList.add(node.val);
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        return preorderList;
    }
}
