/*
 * @lc app=leetcode id=377 lang=cpp
 *
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (49.60%)
 * Likes:    3573
 * Dislikes: 405
 * Total Accepted:    251.8K
 * Total Submissions: 506.6K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit
 * integer.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [9], target = 3
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 *
 *
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 *
 */

// @lc code=start
class Solution {
public:
  int combinationSum4(vector<int> &nums, int target) {
    //   0 1 2 3 4 5 6 7
    // 1 1 1 1 1 1 1 1 1
    // 2 1 1 2 2 3 3 4 5
    // 3 1 1 2 3 4 5 7 9
    vector<unsigned int> dp(target + 1, 0);
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < nums.size(); j++) {
        if (i >= nums[j]) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }
};
// @lc code=end
