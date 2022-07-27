/*
 * @lc app=leetcode id=287 lang=cpp
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (58.85%)
 * Likes:    15263
 * Dislikes: 1927
 * Total Accepted:    931K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 *
 *
 *
 * Follow up:
 *
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 *
 *
 */

// @lc code=start
class Solution {
public:
  int findDuplicate(vector<int> &nums) {
    int n = nums.size() - 1;
    int low = 1;
    int high = n;
    int mid;
    while (low < high) {
      mid = low + (high - low) / 2;
      int count = 0;
      for (int num : nums) {
        if (num <= mid)
          count++;
      }
      if (count > mid)
        high = mid;
      else
        low = mid + 1;
    }
    return low;
  }
};
// @lc code=end
