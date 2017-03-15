package Problem301_400;

import Problem101_200.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mwindson on 2017/3/15.
 * https://leetcode.com/problems/house-robber-iii/#/description
 */
public class Problem337 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[2,1,3,null,4]");
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        return robCal(root)[0];
    }

    private static int[] robCal(TreeNode node) {
        int[] sum = new int[2];//sum[0]:curSum, sum[1]:prevSum,;
        int[] sum1 = new int[2];
        int[] sum2 = new int[2];
        int leftSum = 0;
        int rightSum = 0;
        if (node.left != null)
            sum1 = robCal(node.left);
        if (node.right != null)
            sum2 = robCal(node.right);
        if (node.left == null && node.right == null) {
            sum[0] = node.val;
            sum[1] = 0;
            return sum;
        }
        sum[0] = Math.max(node.val + sum1[1] + sum2[1], sum1[0] + sum2[0]);
        sum[1] = sum1[0] + sum2[0];
        return sum;
    }
}
