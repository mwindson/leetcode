/*
 * @lc app=leetcode id=59 lang=cpp
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (65.17%)
 * Likes:    3734
 * Dislikes: 183
 * Total Accepted:    369.1K
 * Total Submissions: 565.4K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n^2 in spiral order.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 *
 *
 * Example 2:
 *
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 20
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> generateMatrix(int n) {
    vector<vector<int>> matrix(n, vector<int>(n));
    if (n == 0) {
      return matrix;
    }
    int i = 0;
    int j = 0;
    vector<pair<int, int>> nexts = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int nextIndex = 0;

    int num = 1;
    while (num <= n * n) {
      matrix[i][j] = num;
      int nextI = i + nexts[nextIndex].first;
      int nextJ = j + nexts[nextIndex].second;
      if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n ||
          matrix[nextI][nextJ] != 0) {
        nextIndex = nextIndex == 3 ? 0 : nextIndex + 1;
      }
      i = nexts[nextIndex].first + i;
      j = nexts[nextIndex].second + j;
      num++;
    }
    return matrix;
  }
};
// @lc code=end
