/*
 * @lc app=leetcode id=47 lang=cpp
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.56%)
 * Likes:    5756
 * Dislikes: 100
 * Total Accepted:    657.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> permuteUnique(vector<int> &nums) {
    vector<vector<int>> permutations;
    vector<int> permutation;
    for (int num : nums) {
      unused[num] = unused.count(num) > 0 ? unused[num] + 1 : 1;
    }
    sort(nums.begin(), nums.end());
    find(permutations, permutation, nums);
    return permutations;
  }
  void find(vector<vector<int>> &permutations, vector<int> &permutation,
            vector<int> &nums) {
    if (permutation.size() == nums.size()) {
      permutations.emplace_back(permutation);
      return;
    }
    for (int i = 0; i < nums.size(); i++) {
      if (unused[nums[i]] > 0) {
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
          unused[nums[i]]--;
          permutation.emplace_back(nums[i]);
          find(permutations, permutation, nums);
          permutation.pop_back();
          unused[nums[i]]++;
        }
      }
    }
  }

private:
  unordered_map<int, int> unused;
};
// @lc code=end
