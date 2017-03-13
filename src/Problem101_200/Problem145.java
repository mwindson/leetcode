package Problem101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mwindson on 2017/3/13.
 * https://leetcode.com/problems/binary-tree-postorder-traversal/#/description
 */
public class Problem145 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,2,3,4,5,6,7]");
        System.out.println(postorderTraversal(root));
    }

    // 与preorder过程相似，最后将结果倒置即可
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        if (root == null)
            return preorderList;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode node = s.pop();
            preorderList.add(0, node.val);
            if (node.left != null)
                s.push(node.left);
            if (node.right != null)
                s.push(node.right);
        }
        return preorderList;
    }
}
