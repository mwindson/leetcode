/*
 * @lc app=leetcode id=90 lang=cpp
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (53.63%)
 * Likes:    5279
 * Dislikes: 156
 * Total Accepted:    517.7K
 * Total Submissions: 964.8K
 * Testcase Example:  '[1,2,2]'
 *
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 *
 *
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> subsetsWithDup(vector<int> &nums) {
    vector<vector<int>> subsets;
    vector<int> subset;
    sort(nums.begin(), nums.end());
    getSubset(subsets, subset, nums, 0);
    return subsets;
  }
  void getSubset(vector<vector<int>> &subsets, vector<int> &subset,
                 vector<int> &nums, int start) {
    subsets.emplace_back(subset);
    for (int i = start; i < nums.size(); i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      subset.emplace_back(nums[i]);
      getSubset(subsets, subset, nums, i + 1);
      subset.pop_back();
    }
  }
};
// @lc code=end
