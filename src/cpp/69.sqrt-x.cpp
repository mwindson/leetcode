/*
 * @lc app=leetcode id=69 lang=cpp
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (36.60%)
 * Likes:    5139
 * Dislikes: 3644
 * Total Accepted:    1.3M
 * Total Submissions: 3.4M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 *
 *
 * Example 2:
 *
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down
 * to the nearest integer, 2 is returned.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= x <= 2^31 - 1
 *
 *
 */

// @lc code=start
class Solution {
public:
  int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int l = 1;
    int r = x;
    while (l <= r) {
      int mid = (r - l) / 2 + l;
      if (mid > x / mid) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l - 1;
  }
};
// @lc code=end
