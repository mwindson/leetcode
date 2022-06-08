/*
 * @lc app=leetcode id=46 lang=cpp
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.73%)
 * Likes:    10789
 * Dislikes: 192
 * Total Accepted:    1.2M
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> permute(vector<int> &nums) {
    vector<vector<int>> res;
    vector<int> permutation;
    for (int num : nums) {
      used[num] = false;
    }
    find(res, permutation, nums);
    return res;
  }
  void find(vector<vector<int>> &res, vector<int> &permutation,
            vector<int> &nums) {
    if (permutation.size() == nums.size()) {
      res.emplace_back(permutation);
      return;
    }
    for (int num : nums) {
      if (!used[num]) {
        used[num] = true;
        permutation.emplace_back(num);
        find(res, permutation, nums);
        permutation.pop_back();
        used[num] = false;
      }
    }
  }

private:
  unordered_map<int, bool> used;
};
// @lc code=end
