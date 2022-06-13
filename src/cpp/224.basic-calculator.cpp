/*
 * @lc app=leetcode id=224 lang=cpp
 *
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (40.64%)
 * Likes:    3679
 * Dislikes: 297
 * Total Accepted:    298.9K
 * Total Submissions: 735.1K
 * Testcase Example:  '"1 + 1"'
 *
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 *
 *
 * Example 1:
 *
 *
 * Input: s = "1 + 1"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 *
 *
 * Example 3:
 *
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 3 * 10^5
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is
 * invalid).
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is
 * valid).
 * There will be no two consecutive operators in the input.
 * Every number and running calculation will fit in a signed 32-bit integer.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int calculate(string s) {
    stack<int> nums;
    stack<int> signs;
    int res = 0;
    int sign = 1;
    int num = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s[i] >= '0' && s[i] <= '9') {
        num = num * 10 + (s[i] - '0');
      }
      if (s[i] == '(') { // 1-(5)
        //  对于括号内的表达式，相当于重新计算一个子集
        // 暂存外层的计算结果，直到括号内的子表达式计算结束。
        nums.push(res);
        signs.push(sign);
        // 置为初值
        res = 0;
        sign = 1;
      }
      if (s[i] == ')') { // 1 - (5)
        // 括号内计算结束，恢复到外面的计算过程
        res += num * sign;
        num = 0;
        res = nums.top() + signs.top() * res;
        nums.pop();
        signs.pop();
        sign = 1;
      }
      if (s[i] == '+') { // 1+1
        res += num * sign;
        num = 0;
        sign = 1;
      }
      if (s[i] == '-') { // 1+(-1)
        res += num * sign;
        num = 0;
        sign = -1;
      }
    }
    res += num * sign;
    return res;
  }
};
// @lc code=end
