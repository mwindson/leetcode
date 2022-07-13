/*
 * @lc app=leetcode id=357 lang=cpp
 *
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (50.74%)
 * Likes:    968
 * Dislikes: 1265
 * Total Accepted:    104.8K
 * Total Submissions: 205.9K
 * Testcase Example:  '2'
 *
 * Given an integer n, return the count of all numbers with unique digits, x,
 * where 0 <= x < 10^n.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x <
 * 100, excluding 11,22,33,44,55,66,77,88,99
 *
 *
 * Example 2:
 *
 *
 * Input: n = 0
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= n <= 8
 *
 *
 */

// @lc code=start
class Solution {
public:
  int countNumbersWithUniqueDigits(int n) {
    int res = 0;
    for (int i = 0; i <= n; i++) {
      res += countNumber(i);
    }
    return res;
  }
  int countNumber(int n) {
    int res = 1;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        res *= 9;
      } else {
        res *= 10 - i;
      }
    }
    return res;
  }
};
// @lc code=end
