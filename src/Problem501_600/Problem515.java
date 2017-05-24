package Problem501_600;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/5/24.
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/#/description
 */
public class Problem515 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[1,3,4,5,10,11,9]");
        System.out.println(largestValues(root));
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                max = Math.max(max, tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            values.add(max);
        }
        return values;
    }
}
