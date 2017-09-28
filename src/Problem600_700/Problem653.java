package Problem600_700;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwindson on 2017/9/28.
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 */
public class Problem653 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.parse("[5,3,6,2,4,nul,7]");
        int k = 9;
        findTarget(root, k);
    }

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j; ) {
            if (nums.get(i) + nums.get(j) == k) return true;
            if (nums.get(i) + nums.get(j) < k) i++;
            else j--;
        }
        return false;
    }

    public static void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
