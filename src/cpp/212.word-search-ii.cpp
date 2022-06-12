/*
 * @lc app=leetcode id=212 lang=cpp
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (37.78%)
 * Likes:    6106
 * Dislikes: 242
 * Total Accepted:    445.3K
 * Total Submissions: 1.2M
 * Testcase Example:
 '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 *
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 *
 */

// @lc code=start
class Solution {
public:
  struct TrieNode {
    shared_ptr<TrieNode> children[256];
    string word;
    TrieNode() {}
  };
  struct Trie {
    shared_ptr<TrieNode> root = nullptr;
    Trie() { root = make_shared<TrieNode>(); }
    void addWord(const string &word) {
      auto node = root;
      for (char c : word) {
        if (node->children[c - 'a'] == nullptr) {
          node->children[c - 'a'] = make_shared<TrieNode>();
        }
        node = node->children[c - 'a'];
      }
      node->word = word;
    }
  };
  vector<string> findWords(vector<vector<char>> &board, vector<string> &words) {
    // 思路：先构建字典树，然后根据字典树去dfs搜索
    //  如果字典树 dfs搜索矩阵 到达了叶子节点，则说明词可组成。
    Trie tree;
    for (const auto &word : words) {
      tree.addWord(word);
    }

    vector<string> ans;
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[i].size(); j++) {
        search(board, i, j, ans, tree.root);
      }
    }
    return ans;
  }
  void search(vector<vector<char>> &board, int i, int j, vector<string> &ans,
              shared_ptr<TrieNode> node) {
    if (i < 0 || j < 0 || i >= board.size() || j >= board[i].size()) {
      return;
    }
    if (board[i][j] == '*' || node->children[board[i][j] - 'a'] == nullptr) {
      return;
    }
    char origin = board[i][j];
    node = node->children[origin - 'a'];
    if (node->word != "") {
      ans.emplace_back(node->word);
      node->word = ""; // 置空，防止重复的词添加
    }
    board[i][j] = '*';
    search(board, i + 1, j, ans, node);
    search(board, i - 1, j, ans, node);
    search(board, i, j + 1, ans, node);
    search(board, i, j - 1, ans, node);
    board[i][j] = origin;
  }
};
// @lc code=end
