/*
 * @lc app=leetcode id=7 lang=cpp
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (26.78%)
 * Likes:    7964
 * Dislikes: 10412
 * Total Accepted:    2.2M
 * Total Submissions: 8.1M
 * Testcase Example:  '123'
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed
 * or unsigned).
 *
 *
 * Example 1:
 *
 *
 * Input: x = 123
 * Output: 321
 *
 *
 * Example 2:
 *
 *
 * Input: x = -123
 * Output: -321
 *
 *
 * Example 3:
 *
 *
 * Input: x = 120
 * Output: 21
 *
 *
 *
 * Constraints:
 *
 *
 * -2^31 <= x <= 2^31 - 1
 *
 *
 */

// @lc code=start
class Solution {
public:
  int reverse(int x) {
    if (x == INT_MIN) {
      return 0;
    }
    if (x < 0) {
      return -reverse(-x);
    }
    if (x == 0) {
      return 0;
    }
    int res = 0;
    while (x > 0) {
      int n = x % 10;
      x = x / 10;
      if ((INT_MAX - n) / 10 < res) {
        return 0;
      }
      res = res * 10 + n;
    }
    return res;
  }
};
// @lc code=end
