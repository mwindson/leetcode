/*
 * @lc app=leetcode id=22 lang=cpp
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (70.41%)
 * Likes:    13169
 * Dislikes: 504
 * Total Accepted:    1.1M
 * Total Submissions: 1.5M
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 8
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<string> generateParenthesis(int n) {
    vector<string> res;
    string start;
    gen(res, start, 0, 0, n);
    return res;
  }
  void gen(vector<string> &res, string s, int left, int right, int n) {
    if (left == n && right == n) {
      res.emplace_back(s);
      return;
    }
    if (left < n) {
      gen(res, s + "(", left + 1, right, n);
    }
    if (left > right && right < n) {
      gen(res, s + ")", left, right + 1, n);
    }
  }
};
// @lc code=end
