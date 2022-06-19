/*
 * @lc app=leetcode id=885 lang=cpp
 *
 * [885] Spiral Matrix III
 *
 * https://leetcode.com/problems/spiral-matrix-iii/description/
 *
 * algorithms
 * Medium (72.48%)
 * Likes:    539
 * Dislikes: 596
 * Total Accepted:    35.2K
 * Total Submissions: 48.5K
 * Testcase Example:  '1\n4\n0\n0'
 *
 * You start at the cell (rStart, cStart) of an rows x cols grid facing east.
 * The northwest corner is at the first row and column in the grid, and the
 * southeast corner is at the last row and column.
 *
 * You will walk in a clockwise spiral shape to visit every position in this
 * grid. Whenever you move outside the grid's boundary, we continue our walk
 * outside the grid (but may return to the grid boundary later.). Eventually,
 * we reach all rows * cols spaces of the grid.
 *
 * Return an array of coordinates representing the positions of the grid in the
 * order you visited them.
 *
 *
 * Example 1:
 *
 *
 * Input: rows = 1, cols = 4, rStart = 0, cStart = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 *
 *
 * Example 2:
 *
 *
 * Input: rows = 5, cols = 6, rStart = 1, cStart = 4
 * Output:
 * [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= rows, cols <= 100
 * 0 <= rStart < rows
 * 0 <= cStart < cols
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> spiralMatrixIII(int rows, int cols, int rStart,
                                      int cStart) {
    vector<vector<int>> ans;
    if (rows == 0 || cols == 0) {
      return ans;
    }
    vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dir = 0;
    int diff = 1;
    int num = 1;
    while (ans.size() < rows * cols) {
      for (int j = 0; j < 2; j++) {
        for (int i = 0; i < diff; i++) {
          if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
            ans.emplace_back(vector<int>{rStart, cStart});
          }
          rStart += directions[dir % 4].first;
          cStart += directions[dir % 4].second;
          num++;
        }
        dir++;
      }
      diff++;
    }
    return ans;
  }
};
// @lc code=end
