/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHouse(nums, 0, nums.length - 2), robHouse(nums, 1, nums.length - 1));
    }

    int robHouse(int[] nums, int start, int end) {
        int length = end - start + 1;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[start];
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + start - 1], dp[i - 1]);
        }
        return dp[length];
    }

}
// @lc code=end
