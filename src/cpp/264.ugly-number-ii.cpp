/*
 * @lc app=leetcode id=264 lang=cpp
 *
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (45.39%)
 * Likes:    4400
 * Dislikes: 222
 * Total Accepted:    272K
 * Total Submissions: 594.3K
 * Testcase Example:  '10'
 *
 * An ugly number is a positive integer whose prime factors are limited to 2,
 * 3, and 5.
 *
 * Given an integer n, return the n^th ugly number.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first
 * 10 ugly numbers.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are
 * limited to 2, 3, and 5.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 1690
 *
 *
 */

// @lc code=start
class Solution {
public:
  int nthUglyNumber(int n) {
    int i2 = 0;
    int i3 = 0;
    int i5 = 0;
    vector<int> nums(n, 0);
    nums[0] = 1;
    for (int i = 1; i < n; i++) {
      nums[i] = min(nums[i2] * 2, min(nums[i3] * 3, nums[i5] * 5));
      if (nums[i] == nums[i2] * 2) {
        i2++;
      }
      if (nums[i] == nums[i3] * 3) {
        i3++;
      }
      if (nums[i] == nums[i5] * 5) {
        i5++;
      }
    }
    return nums[n - 1];
  }
};
// @lc code=end
