package Problem401_500;

import Util.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mwindson on 2017/3/27.
 * https://leetcode.com/problems/path-sum-iii/#/description
 */
public class Problem437 {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[10,5,-3,3,2,null,11,3,-2,null,1]");
        System.out.println(pathSum(root, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
