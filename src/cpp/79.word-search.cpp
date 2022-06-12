/*
 * @lc app=leetcode id=79 lang=cpp
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (39.78%)
 * Likes:    9536
 * Dislikes: 356
 * Total Accepted:    990K
 * Total Submissions: 2.5M
 * Testcase Example:
 * '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a
 * larger board?
 *
 */

// @lc code=start
class Solution {
public:
  bool exist(vector<vector<char>> &board, string word) {
    int m = board.size();
    int n = board[0].size();
    vector<vector<bool>> visited(m, vector<bool>(n, false));
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[i].size(); j++) {
        if (findNext(board, word, i, j, 0, visited)) {
          return true;
        }
      }
    }
    return false;
  }
  bool findNext(vector<vector<char>> &board, string word, int i, int j,
                int wordIndex, vector<vector<bool>> &visited) {
    if (wordIndex >= word.size()) {
      return true;
    }
    if (i < 0 || j < 0 || i >= board.size() || j >= board[i].size() ||
        visited[i][j] || board[i][j] != word[wordIndex]) {
      return false;
    }
    visited[i][j] = true;
    if (findNext(board, word, i + 1, j, wordIndex + 1, visited)) {
      return true;
    }
    if (findNext(board, word, i - 1, j, wordIndex + 1, visited)) {
      return true;
    }
    if (findNext(board, word, i, j + 1, wordIndex + 1, visited)) {
      return true;
    }
    if (findNext(board, word, i, j - 1, wordIndex + 1, visited)) {
      return true;
    }
    visited[i][j] = false;
    return false;
  }
};
// @lc code=end
