/*
 * @lc app=leetcode id=40 lang=cpp
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (52.52%)
 * Likes:    5710
 * Dislikes: 147
 * Total Accepted:    579.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> combinationSum2(vector<int> &candidates, int target) {
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
      solve(candidates, ans, curr, target, sum + candidates[i], i + 1);
      curr.pop_back();
    }
  }
};
// @lc code=end
