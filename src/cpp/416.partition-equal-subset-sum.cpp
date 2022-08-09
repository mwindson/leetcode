/*
 * @lc app=leetcode id=416 lang=cpp
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (46.51%)
 * Likes:    8440
 * Dislikes: 135
 * Total Accepted:    498.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool canPartition(vector<int> &nums) {
    // 转化成01背包问题：每个数选或不选，最终选择数之和为sum/2;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum /= 2;
    vector<int> dp(sum + 1, false);
    dp[0] = true;
    for (int i = 0; i < nums.size(); i++) {
      for (int j = sum; j >= nums[i]; j--) {
        dp[j] = dp[j] || dp[j - nums[i]];
      }
    }
    return dp[sum];
  }
};
// @lc code=end
