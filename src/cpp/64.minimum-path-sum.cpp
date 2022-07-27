/*
 * @lc app=leetcode id=64 lang=cpp
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (59.57%)
 * Likes:    8023
 * Dislikes: 109
 * Total Accepted:    751K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its
 * path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 *
 */

// @lc code=start
class Solution {
public:
  int minPathSum(vector<vector<int>> &grid) {
    if (grid.size() == 0) {
      return 0;
    }
    vector<int> path_sum(grid[0].size(), 0);
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[i].size(); j++) {
        if (j == 0) {
          path_sum[j] = path_sum[j] + grid[i][j];
        } else if (i == 0) {
          path_sum[j] = path_sum[j - 1] + grid[i][j];
        } else {
          path_sum[j] = min(path_sum[j], path_sum[j - 1]) + grid[i][j];
        }
      }
    }
    return path_sum[grid[0].size() - 1];
  }
};
// @lc code=end
