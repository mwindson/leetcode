/*
 * @lc app=leetcode id=397 lang=cpp
 *
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (34.77%)
 * Likes:    930
 * Dislikes: 441
 * Total Accepted:    87.7K
 * Total Submissions: 250.7K
 * Testcase Example:  '8'
 *
 * Given a positive integer n, you can apply one of the following
 * operations:
 *
 *
 * If n is even, replace n with n / 2.
 * If n is odd, replace n with either n + 1 or n - 1.
 *
 *
 * Return the minimum number of operations needed for n to become 1.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: 8 -> 4 -> 2 -> 1
 *
 *
 * Example 2:
 *
 *
 * Input: n = 7
 * Output: 4
 * Explanation: 7 -> 8 -> 4 -> 2 -> 1
 * or 7 -> 6 -> 3 -> 2 -> 1
 *
 *
 * Example 3:
 *
 *
 * Input: n = 4
 * Output: 2
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
  int integerReplacement(int n) { return dfs(n); }
  int dfs(long n) {
    if (n == 1) {
      return 0;
    }
    if (n % 2 == 0) {
      return dfs(n / 2) + 1;
    } else {
      return min<int>(dfs(n + 1), dfs(n - 1)) + 1;
    }
  }
};
// @lc code=end
