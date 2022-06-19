/*
 * @lc app=leetcode id=54 lang=cpp
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (41.77%)
 * Likes:    7465
 * Dislikes: 844
 * Total Accepted:    755.8K
 * Total Submissions: 1.8M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> spiralOrder(vector<vector<int>> &matrix) {
    vector<int> ans;
    if (matrix.size() == 0) {
      return ans;
    }
    int m = matrix.size();
    int n = matrix[0].size();
    int i = 0;
    int j = 0;
    vector<pair<int, int>> nexts = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int nextIndex = 0;
    while (ans.size() < m * n) {
      ans.emplace_back(matrix[i][j]);
      matrix[i][j] = 999;
      auto next = nexts[nextIndex];
      int nextI = i + next.first;
      int nextJ = j + next.second;
      if (nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n ||
          matrix[nextI][nextJ] == 999) {
        nextIndex = nextIndex >= 3 ? 0 : nextIndex + 1;
      }
      next = nexts[nextIndex];
      i = i + next.first;
      j = j + next.second;
    }
    return ans;
  }
};
// @lc code=end
