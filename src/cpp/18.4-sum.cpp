/*
 * @lc app=leetcode id=18 lang=cpp
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (37.41%)
 * Likes:    7270
 * Dislikes: 850
 * Total Accepted:    633.3K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 *
 * You may return the answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> fourSum(vector<int> &nums, int target) {
    vector<vector<int>> res;
    sort(nums.begin(), nums.end(), [](int a, int b) { return a < b; });
    for (int i = 0; i < nums.size(); i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.size(); j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        long remain = (long)target - nums[i] - nums[j];
        int left = j + 1;
        int right = nums.size() - 1;
        while (left < right) {
          if (left > j + 1 && nums[left] == nums[left - 1]) {
            left++;
            continue;
          }
          if (right < nums.size() - 1 && nums[right] == nums[right + 1]) {
            right--;
            continue;
          }
          if (nums[left] + nums[right] > remain) {
            right--;
          } else if (nums[left] + nums[right] < remain) {
            left++;
          } else {
            res.emplace_back(
                vector<int>{nums[i], nums[j], nums[left], nums[right]});
            left++;
            right--;
          }
        }
      }
    }
    return res;
  }
};
// @lc code=end
