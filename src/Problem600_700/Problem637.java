package Problem600_700;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/7/14.
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/#/description
 */
public class Problem637 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[3,9,20,15,7]");
        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                sum += t.val;
                if (t.left != null)
                    queue.add(t.left);
                if (t.right != null)
                    queue.add(t.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
