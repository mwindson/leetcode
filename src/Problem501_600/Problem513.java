package Problem501_600;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by mwindson on 2017/5/31.
 * https://leetcode.com/problems/find-bottom-left-tree-value/#/description
 */
public class Problem513 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[]");
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int bottomLeftValue = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) bottomLeftValue = node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return bottomLeftValue;
    }
}
