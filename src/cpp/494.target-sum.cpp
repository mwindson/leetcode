/*
 * @lc app=leetcode id=494 lang=cpp
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (45.39%)
 * Likes:    7705
 * Dislikes: 280
 * Total Accepted:    387.2K
 * Total Submissions: 853.2K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the
 * integers.
 *
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 *
 *
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be
 * target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 *
 */

// @lc code=start
class Solution {
public:
  int findTargetSumWays(vector<int> &nums, int target) {
    // 所有正数之和为 A， 所有负数之和为B，
    // 则sum=A+B，target= A-B => A = (sum+target)/2
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (target > sum || target < -sum) {
      return 0;
    }
    if ((sum + target) % 2 != 0) {
      return 0;
    }
    int cap = (sum - target) / 2 + target;
    vector<int> dp(cap + 1, 0);
    dp[0] = 1;
    for (int i = 0; i < nums.size(); i++) {
      for (int j = cap; j >= nums[i]; j--) {
        dp[j] = dp[j] + dp[j - nums[i]];
      }
    }
    return dp[cap];
  }
};
// @lc code=end
