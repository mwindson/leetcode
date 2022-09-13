/*
 * @lc app=leetcode id=491 lang=cpp
 *
 * [491] Increasing Subsequences
 *
 * https://leetcode.com/problems/increasing-subsequences/description/
 *
 * algorithms
 * Medium (51.13%)
 * Likes:    1672
 * Dislikes: 155
 * Total Accepted:    82.2K
 * Total Submissions: 158.7K
 * Testcase Example:  '[4,6,7,7]'
 *
 * Given an integer array nums, return all the different possible increasing
 * subsequences of the given array with at least two elements. You may return
 * the answer in any order.
 *
 * The given array may contain duplicates, and two equal integers should also
 * be considered a special case of increasing sequence.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> findSubsequences(vector<int> &nums) {
    vector<int> prev;
    vector<vector<int>> seqs;
    search(nums, 0, prev, seqs);
    return seqs;
  }
  void search(vector<int> &nums, int index, vector<int> &prev,
              vector<vector<int>> &seqs) {
    if (prev.size() >= 2) {
      seqs.emplace_back(prev);
    }
    unordered_set<int> checked; // 记录一下已经遍历的值。
    for (int i = index; i < nums.size(); i++) {
      if (prev.size() > 0 && nums[i] < prev[prev.size() - 1]) {
        continue;
      }
      if (checked.count(nums[i]) > 0) {
        continue;
      }
      prev.emplace_back(nums[i]);
      search(nums, i + 1, prev, seqs);
      prev.pop_back();
      checked.insert(nums[i]);
    }
  }
};
// @lc code=end
