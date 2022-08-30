/*
 * @lc app=leetcode id=43 lang=cpp
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (37.91%)
 * Likes:    5014
 * Dislikes: 2077
 * Total Accepted:    564.4K
 * Total Submissions: 1.5M
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs
 * to integer directly.
 *
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Constraints:
 *
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string multiply(string num1, string num2) {
    int m = num1.length();
    int n = num2.length();
    vector<int> vec(m + n, 0);
    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        int val1 = num1[i] - '0';
        int val2 = num2[j] - '0';
        vec[m + n - 2 - i - j] = vec[m + n - 2 - i - j] + val1 * val2;
      }
    }
    string prod;
    int carry_bit = 0;
    for (int i = 0; i < vec.size(); i++) {
      int val = vec[i] + carry_bit;
      prod = to_string(val % 10) + prod;
      carry_bit = val / 10;
    }
    int index = 0;
    while (index < prod.length()) {
      if (prod[index] != '0') {
        break;
      }
      index++;
    }
    prod = prod.substr(index);
    return prod.empty() ? "0" : prod;
  }
};
// @lc code=end
