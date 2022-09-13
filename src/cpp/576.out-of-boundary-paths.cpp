/*
 * @lc app=leetcode id=576 lang=cpp
 *
 * [576] Out of Boundary Paths
 *
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 *
 * algorithms
 * Medium (40.20%)
 * Likes:    2807
 * Dislikes: 224
 * Total Accepted:    110.7K
 * Total Submissions: 250K
 * Testcase Example:  '2\n2\n2\n0\n0'
 *
 * There is an m x n grid with a ball. The ball is initially at the position
 * [startRow, startColumn]. You are allowed to move the ball to one of the four
 * adjacent cells in the grid (possibly out of the grid crossing the grid
 * boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the
 * number of paths to move the ball out of the grid boundary. Since the answer
 * can be very large, return it modulo 10^9 + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 *
 *
 * Example 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 *
 *
 */

// @lc code=start
class Solution {
public:
  long mod = 1000000007;
  unordered_map<string, long> memo;
  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    return move(m, n, maxMove, startRow, startColumn);
  }
  int move(int m, int n, int maxMove, int row, int col) {
    if (row < 0 || row >= m || col < 0 || col >= n) {
      return 1;
    }
    if (maxMove == 0) {
      return 0;
    }
    string key = to_string(n * row + col) + "_" + to_string(maxMove);
    if (memo.count(key) > 0) {
      return memo[key];
    }
    long cnt = 0;
    cnt = (cnt + move(m, n, maxMove - 1, row + 1, col) % mod) % mod;
    cnt = (cnt + move(m, n, maxMove - 1, row - 1, col) % mod) % mod;
    cnt = (cnt + move(m, n, maxMove - 1, row, col + 1 % mod)) % mod;
    cnt = (cnt + move(m, n, maxMove - 1, row, col - 1) % mod) % mod;
    memo[key] = cnt;
    return cnt;
  }
};
// @lc code=end
