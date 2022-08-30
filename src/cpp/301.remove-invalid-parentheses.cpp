/*
 * @lc app=leetcode id=301 lang=cpp
 *
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (46.92%)
 * Likes:    5031
 * Dislikes: 251
 * Total Accepted:    363.1K
 * Total Submissions: 772.5K
 * Testcase Example:  '"()())()"'
 *
 * Given a string s that contains parentheses and letters, remove the minimum
 * number of invalid parentheses to make the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 *
 *
 * Example 2:
 *
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 *
 *
 * Example 3:
 *
 *
 * Input: s = ")("
 * Output: [""]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<string> removeInvalidParentheses(string s) {
    unordered_set<string> result;
    int left_removed = 0;
    int right_removed = 0;
    // 遍历一次，计算多少个括号需要移除
    for (auto c : s) {
      if (c == '(') {
        ++left_removed;
      }
      if (c == ')') {
        if (left_removed != 0) {
          --left_removed;
        } else {
          ++right_removed;
        }
      }
    }
    if (left_removed == 0 && right_removed == 0) {
      return {s};
    }
    helper(s, 0, left_removed, right_removed, 0, "", result);
    return vector<string>(result.begin(), result.end());
  }

private:
  void helper(string s, int index, int left_removed, int right_removed,
              int pair, string path, unordered_set<string> &result) {
    if (left_removed + right_removed > s.length() - index) {
      return;
    }
    if (index == s.size()) {
      if (left_removed == 0 && right_removed == 0 && pair == 0) {
        result.insert(path);
      }
      return;
    }
    if (s[index] != '(' && s[index] != ')') {
      helper(s, index + 1, left_removed, right_removed, pair, path + s[index],
             result);
    } else {
      if (s[index] == '(') {
        if (left_removed > 0) { // 移除(
          helper(s, index + 1, left_removed - 1, right_removed, pair, path,
                 result);
        }
        // 保存(
        helper(s, index + 1, left_removed, right_removed, pair + 1,
               path + s[index], result);
      }
      if (s[index] == ')') {
        if (right_removed > 0) { // 移除)
          helper(s, index + 1, left_removed, right_removed - 1, pair, path,
                 result);
        }
        if (pair > 0) { // 如果有对应的(,则可以保留
          helper(s, index + 1, left_removed, right_removed, pair - 1,
                 path + s[index], result);
        }
      }
    }
  }
};
// @lc code=end
