/*
 * @lc app=leetcode id=78 lang=cpp
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (71.86%)
 * Likes:    10225
 * Dislikes: 157
 * Total Accepted:    1.1M
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> subsets(vector<int> &nums) {
    vector<vector<int>> res;
    vector<int> init;
    getOneSubset(res, init, 0, nums);
    return res;
  }
  void getOneSubset(vector<vector<int>> &res, vector<int> &curr, int start,
                    const vector<int> &nums) {
    res.emplace_back(curr);
    for (int i = start; i < nums.size(); i++) {
      curr.emplace_back(nums[i]);
      getOneSubset(res, curr, i + 1, nums);
      curr.pop_back();
    }
  }
};
// @lc code=end
