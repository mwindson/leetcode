/*
 * @lc app=leetcode id=150 lang=cpp
 *
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (42.96%)
 * Likes:    3228
 * Dislikes: 644
 * Total Accepted:    432K
 * Total Submissions: 1M
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or
 * another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means
 * the expression would always evaluate to a result, and there will not be any
 * division by zero operation.
 *
 *
 * Example 1:
 *
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 *
 * Example 2:
 *
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 *
 * Example 3:
 *
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
 * range [-200, 200].
 *
 *
 */

// @lc code=start
class Solution {
public:
  int evalRPN(vector<string> &tokens) {
    stack<int> nums;
    for (const string &token : tokens) {
      int num;
      if (token == "+") {
        int a = nums.top();
        nums.pop();
        int b = nums.top();
        nums.pop();
        num = b + a;
      } else if (token == "-") {
        int a = nums.top();
        nums.pop();
        int b = nums.top();
        nums.pop();
        num = b - a;
      } else if (token == "*") {
        int a = nums.top();
        nums.pop();
        int b = nums.top();
        nums.pop();
        num = b * a;
      } else if (token == "/") {
        int a = nums.top();
        nums.pop();
        int b = nums.top();
        nums.pop();
        num = b / a;
      } else {
        num = stoi(token);
      }
      nums.push(num);
    }
    return nums.top();
  }
};
// @lc code=end
