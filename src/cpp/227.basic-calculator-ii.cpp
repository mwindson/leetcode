/*
 * @lc app=leetcode id=227 lang=cpp
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (41.71%)
 * Likes:    4411
 * Dislikes: 577
 * Total Accepted:    437.5K
 * Total Submissions: 1M
 * Testcase Example:  '"3+2*2"'
 *
 * Given a string s which represents an expression, evaluate this expression
 * and return its value. 
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2^31, 2^31 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 *
 *
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range
 * [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int calculate(string s) {
    stack<int> nums;
    stack<char> ops;
    string numStr = "";
    s += "#";
    for (char c : s) {
      if (c >= '0' && c <= '9') {
        numStr = numStr + c;
      } else {
        if (numStr != "") {
          nums.push(stoi(numStr));
          numStr = "";
        }
        if (c == '+' || c == '-') {
          while (!ops.empty()) {
            calOnce(nums, ops);
          }
          ops.push(c);
        }
        if (c == '*' || c == '/') {
          while (!ops.empty() && (ops.top() == '*' || ops.top() == '/')) {
            calOnce(nums, ops);
          }
          ops.push(c);
        }
      }
    }
    while (!ops.empty()) {
      calOnce(nums, ops);
    }
    return nums.empty() ? 0 : nums.top();
  }
  void calOnce(stack<int> &nums, stack<char> &ops) {
    int a = nums.top();
    nums.pop();
    int b = nums.top();
    nums.pop();
    char op = ops.top();
    ops.pop();

    int res = 0;
    switch (op) {
    case '+':
      res = b + a;
      nums.push(res);
      break;
    case '-':
      res = b - a;
      nums.push(res);
      break;
    case '*':
      res = b * a;
      nums.push(res);
      break;
    case '/':
      res = b / a;
      nums.push(res);
      break;
    default:
      break;
    }
  }
};
// @lc code=end
