package Problem600_700;

import Util.TreeNode;

/**
 * Created by mwindson on 2017/8/6.
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class Problem654 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println(root);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public static TreeNode construct(int[] nums, int left, int right) {
        if (left == right) return null;
        int max = 0;
        int index = left;
        for (int i = left; i < right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(nums, left, index);
        node.right = construct(nums, index + 1, right);
        return node;
    }
}
