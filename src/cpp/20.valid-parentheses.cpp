/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.86%)
 * Likes:    13484
 * Dislikes: 610
 * Total Accepted:    2.3M
 * Total Submissions: 5.7M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "()"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool isValid(string s) {
    stack<char> stack;
    for (char c : s) {
      switch (c) {
      case '(':
        stack.push(c);
        break;
      case ')':
        if (stack.empty() || stack.top() != '(') {
          return false;
        }
        stack.pop();
        break;
      case '{':
        stack.push(c);
        break;
      case '}':
        if (stack.empty() || stack.top() != '{') {
          return false;
        }
        stack.pop();
        break;
      case '[':
        stack.push(c);
        break;
      case ']':
        if (stack.empty() || stack.top() != '[') {
          return false;
        }
        stack.pop();
        break;
      }
    }
    return stack.empty();
  }
};
// @lc code=end
