/*
 * @lc app=leetcode id=400 lang=cpp
 *
 * [400] Nth Digit
 *
 * https://leetcode.com/problems/nth-digit/description/
 *
 * algorithms
 * Medium (33.58%)
 * Likes:    725
 * Dislikes: 1640
 * Total Accepted:    79.3K
 * Total Submissions: 234.2K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the n^th digit of the infinite integer sequence
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: n = 11
 * Output: 0
 * Explanation: The 11^th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * 11, ... is a 0, which is part of the number 10.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 2^31 - 1
 *
 *
 */

// @lc code=start
class Solution {
public:
  int findNthDigit(int n) {
    // 1*9 +2*90+3*990
    int len = 1;
    long pow = 1;
    while (n > len * 9 * pow) {
      n -= len * 9 * pow;
      pow *= 10;
      len += 1;
    }
    long long num = pow + (n - 1) / len;
    n = len - (n - 1) % len;
    while (n > 1) {
      num /= 10;
      n--;
    }
    return num % 10;
  }
};
// @lc code=end
