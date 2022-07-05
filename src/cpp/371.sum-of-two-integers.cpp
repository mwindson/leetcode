/*
 * @lc app=leetcode id=371 lang=cpp
 *
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Medium (50.61%)
 * Likes:    2679
 * Dislikes: 3972
 * Total Accepted:    311.3K
 * Total Submissions: 615.3K
 * Testcase Example:  '1\n2'
 *
 * Given two integers a and b, return the sum of the two integers without using
 * the operators + and -.
 *
 *
 * Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * Input: a = 2, b = 3
 * Output: 5
 *
 *
 * Constraints:
 *
 *
 * -1000 <= a, b <= 1000
 *
 *
 */

// @lc code=start
class Solution {
public:
  int getSum(int a, int b) {
    while (b) {
      int carry = a & b;
      a = a ^ b;
      b = (unsigned)carry << 1;
    }
    return a;
  }
};
// @lc code=end
