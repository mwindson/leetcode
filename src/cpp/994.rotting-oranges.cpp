/*
 * @lc app=leetcode id=994 lang=cpp
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.com/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (51.82%)
 * Likes:    7123
 * Dislikes: 283
 * Total Accepted:    415K
 * Total Submissions: 799.4K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * You are given an m x n grid where each cell can have one of three
 * values:
 *
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 *
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never
 * rotten, because rotting only happens 4-directionally.
 *
 *
 * Example 3:
 *
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int orangesRotting(vector<vector<int>> &grid) {
    if (grid.size() == 0) {
      return -1;
    }
    int minitue = 0;
    deque<pair<int, int>> q;
    vector<pair<int, int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m = grid.size();
    int n = grid[0].size();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          q.push_back({i, j});
        }
      }
    }
    if (!q.empty()) {
      minitue = -1;
    }
    while (!q.empty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        auto curr = q.front();
        q.pop_front();
        for (auto &dir : dirs) {
          int a = dir.first + curr.first;
          int b = dir.second + curr.second;
          if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] == 1) {
            q.push_back({a, b});
            grid[a][b] = 2;
          }
        }
      }
      minitue += 1;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          return -1;
        }
      }
    }
    return minitue;
  }
};
// @lc code=end
