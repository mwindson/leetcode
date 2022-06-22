/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (51.18%)
 * Likes:    12302
 * Dislikes: 376
 * Total Accepted:    1.6M
 * Total Submissions: 3.2M
 * Testcase Example:  '2'
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 *
 * Example 2:
 *
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 45
 *
 *
 */

// @lc code=start
class Solution {
public:
  int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int first = 1;
    int second = 1;
    for (int i = 2; i <= n; i++) {
      int tmp = second;
      second = second + first;
      first = tmp;
    }
    return second;
  }
};
// @lc code=end
