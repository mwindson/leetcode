/*
 * @lc app=leetcode id=542 lang=cpp
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (43.85%)
 * Likes:    4960
 * Dislikes: 238
 * Total Accepted:    265.1K
 * Total Submissions: 602.9K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 *
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> updateMatrix(vector<vector<int>> &mat) {
    if (mat.size() == 0 || mat[0].size() == 0) {
      return mat;
    }
    vector<vector<int>> dis(mat.size(), vector<int>(mat[0].size(), -1));
    deque<pair<int, int>> q;
    vector<pair<int, int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    for (int i = 0; i < mat.size(); i++) {
      for (int j = 0; j < mat[i].size(); j++) {
        if (mat[i][j] == 0) {
          q.push_back({i, j});
          dis[i][j] = 0;
        }
      }
    }
    while (!q.empty()) {
      auto curr = q.front();
      q.pop_front();
      for (auto &n : dirs) {
        int a = n.first + curr.first;
        int b = n.second + curr.second;
        if (a >= 0 && a < mat.size() && b >= 0 && b < mat[a].size() &&
            dis[a][b] == -1) {
          q.push_back({a, b});
          dis[a][b] = dis[curr.first][curr.second] + 1;
        }
      }
    }
    return dis;
  }
};
// @lc code=end
