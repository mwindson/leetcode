/*
 * @lc app=leetcode id=39 lang=cpp
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (65.92%)
 * Likes:    11518
 * Dislikes: 246
 * Total Accepted:    1.1M
 * Total Submissions: 1.7M
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to
 * target is less than 150 combinations for the given input.
 *
 *
 * Example 1:
 *
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 *
 * Example 3:
 *
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
    vector<vector<int>> ans;
    if (candidates.size() == 0) {
      return ans;
    }
    sort(candidates.begin(), candidates.end());
    vector<int> curr;
    solve(candidates, ans, curr, target, 0, 0);
    return ans;
  }
  void solve(vector<int> &candidates, vector<vector<int>> &ans,
             vector<int> &curr, int target, int sum, int index) {
    if (sum == target) {
      ans.emplace_back(curr);
      return;
    }
    if (sum > target) {
      return;
    }
    for (int i = index; i < candidates.size(); i++) {
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      curr.emplace_back(candidates[i]);
      solve(candidates, ans, curr, target, sum + candidates[i], i);
      curr.pop_back();
    }
  }
};
// @lc code=end
