/*
 * @lc app=leetcode id=169 lang=cpp
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (63.11%)
 * Likes:    10978
 * Dislikes: 363
 * Total Accepted:    1.3M
 * Total Submissions: 2.1M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 *
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

// @lc code=start
class Solution {
public:
  int majorityElement(vector<int> &nums) {
    int major = 0, count = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (count == 0) {
        major = nums[i];
        count++;
      } else if (major == nums[i]) {
        count++;
      } else {
        count--;
      }
    }

    return major;
  }
};
// @lc code=end
