/*
 * @lc app=leetcode id=130 lang=cpp
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (34.31%)
 * Likes:    5183
 * Dislikes: 1267
 * Total Accepted:    435K
 * Total Submissions: 1.3M
 * Testcase Example:
 * '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output:
 * [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means
 * that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that
 * is not on the border and it is not connected to an 'O' on the border will be
 * flipped to 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 *
 *
 * Example 2:
 *
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 *
 */

// @lc code=start
class Solution {
public:
  void solve(vector<vector<char>> &board) {
    for (int i = 0; i < board.size(); i++) {
      if (board[i][0] == 'O') {
        dfs(board, i, 0);
      }
    }
    for (int i = 0; i < board.size(); i++) {
      if (board[i][board[i].size() - 1] == 'O') {
        dfs(board, i, board[i].size() - 1);
      }
    }
    for (int j = 0; j < board[0].size(); j++) {
      if (board[0][j] == 'O') {
        dfs(board, 0, j);
      }
    }
    for (int j = 0; j < board[0].size(); j++) {
      if (board[board.size() - 1][j] == 'O') {
        dfs(board, board.size() - 1, j);
      }
    }
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[i].size(); j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'V') {
          board[i][j] = 'O';
        }
      }
    }
  }
  void dfs(vector<vector<char>> &board, int i, int j) {
    if (i < 0 || j < 0 || i >= board.size() || j >= board[i].size()) {
      return;
    }
    if (board[i][j] == 'X') {
      return;
    }
    if (board[i][j] == 'V') {
      return;
    }
    board[i][j] = 'V';
    dfs(board, i + 1, j);
    dfs(board, i - 1, j);
    dfs(board, i, j + 1);
    dfs(board, i, j - 1);
  }
};
// @lc code=end
