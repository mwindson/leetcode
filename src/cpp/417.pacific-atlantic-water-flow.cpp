/*
 * @lc app=leetcode id=417 lang=cpp
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (49.71%)
 * Likes:    3983
 * Dislikes: 889
 * Total Accepted:    219.2K
 * Total Submissions: 436.6K
 * Testcase Example:
 * '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x
 * n integer matrix heights where heights[r][c] represents the height above sea
 * level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to
 * neighboring cells directly north, south, east, and west if the neighboring
 * cell's height is less than or equal to the current cell's height. Water can
 * flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
 * denotes that rain water can flow from cell (ri, ci) to both the Pacific and
 * Atlantic oceans.
 *
 *
 * Example 1:
 *
 *
 * Input: heights =
 * [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 *
 * Example 2:
 *
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10^5
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> pacificAtlantic(vector<vector<int>> &heights) {
    vector<vector<int>> ans;
    if (heights.size() == 0) {
      return ans;
    }
    int m = heights.size();
    int n = heights[0].size();
    vector<vector<int>> mask(m, vector<int>(n, 0));
    vector<vector<bool>> pacific(m, vector<bool>(n, false));
    vector<vector<bool>> atlantic(m, vector<bool>(n, false));
    for (int i = 0; i < m; i++) {
      dfs(heights, i, 0, mask, pacific, ans, 1);
      dfs(heights, i, n - 1, mask, atlantic, ans, 2);
    }
    for (int j = 0; j < n; j++) {
      dfs(heights, 0, j, mask, pacific, ans, 1);
      dfs(heights, m - 1, j, mask, atlantic, ans, 2);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mask[i][j] == 3) {
          ans.emplace_back(vector<int>{i, j});
        }
      }
    }
    return ans;
  }
  void dfs(vector<vector<int>> &heights, int i, int j,
           vector<vector<int>> &mask, vector<vector<bool>> &visited,
           vector<vector<int>> &ans, int from) {
    visited[i][j] = true;
    mask[i][j] |= from;

    vector<pair<int, int>> diffs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (auto &diff : diffs) {
      int a = i + diff.first;
      int b = j + diff.second;
      if (a < 0 || b < 0 || a >= heights.size() || b >= heights[i].size() ||
          visited[a][b] || heights[a][b] < heights[i][j]) {
        continue;
      }
      dfs(heights, a, b, mask, visited, ans, from);
    }
  }
};
// @lc code=end
