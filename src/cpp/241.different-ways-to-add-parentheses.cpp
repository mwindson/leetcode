/*
 * @lc app=leetcode id=241 lang=cpp
 *
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (61.95%)
 * Likes:    4083
 * Dislikes: 198
 * Total Accepted:    175.4K
 * Total Submissions: 279.6K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string expression of numbers and operators, return all possible
 * results from computing all the different possible ways to group numbers and
 * operators. You may return the answer in any order.
 *
 * The test cases are generated such that the output values fit in a 32-bit
 * integer and the number of different results does not exceed 10^4.
 *
 *
 * Example 1:
 *
 *
 * Input: expression = "2-1-1"
 * Output: [0,2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 *
 * Example 2:
 *
 *
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= expression.length <= 20
 * expression consists of digits and the operator '+', '-', and '*'.
 * All the integer values in the input expression are in the range [0, 99].
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> diffWaysToCompute(string expression) {
    vector<int> nums;
    vector<char> ops;
    int num = -1;
    for (int i = 0; i < expression.length(); i++) {
      if (expression[i] >= '0' && expression[i] <= '9') {
        if (num == -1) {
          num = expression[i] - '0';
        } else {
          num = num * 10 + (expression[i] - '0');
        }
      } else {
        if (num != -1) {
          nums.emplace_back(num);
          num = -1;
        }
        ops.emplace_back(expression[i]);
      }
    }
    if (num >= 0) {
      nums.emplace_back(num);
    }
    return compute(nums, ops, 0, nums.size() - 1, 0, ops.size() - 1);
  }
  vector<int> compute(const vector<int> &nums, const vector<char> &ops,
                      int numl, int numr, int opl, int opr) {
    string key = to_string(numl) + "_" + to_string(numr);
    if (memo.count(key) > 0) {
      return memo.at(key);
    }
    vector<int> res;
    if (numl > numr) {
      return res;
    }
    if (numl == numr) {
      res.emplace_back(nums[numl]);
      memo[key] = res;
      return res;
    }
    for (int i = opl; i <= opr; i++) {
      vector<int> left = compute(nums, ops, numl, i, opl, i - 1);
      vector<int> right = compute(nums, ops, i + 1, numr, i + 1, opr);
      for (int l : left) {
        for (int r : right) {
          if (ops[i] == '-') {
            res.emplace_back(l - r);
          }
          if (ops[i] == '*') {
            res.emplace_back(l * r);
          }
          if (ops[i] == '+') {
            res.emplace_back(l + r);
          }
        }
      }
    }
    memo[key] = res;
    return res;
  }

private:
  unordered_map<string, vector<int>> memo;
};
// @lc code=end
