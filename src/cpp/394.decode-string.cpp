/*
 * @lc app=leetcode id=394 lang=cpp
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (56.48%)
 * Likes:    9158
 * Dislikes: 401
 * Total Accepted:    545.9K
 * Total Submissions: 956.4K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there will not be input
 * like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never
 * exceed 10^5.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 *
 * Example 2:
 *
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 *
 * Example 3:
 *
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets
 * '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 *
 */

// @lc code=start
class Solution {
public:
  string decodeString(string s) {
    int num = 0;
    stack<int> nums;
    stack<string> stack;
    for (int i = 0; i < s.length(); i++) {
      if (s[i] >= '0' && s[i] <= '9') {
        num = num * 10 + (s[i] - '0');
      } else if (s[i] == '[') {
        stack.push("[");
        nums.push(num);
        num = 0;
      } else if (s[i] == ']') {
        string str;
        while (!stack.empty() && stack.top() != "[") {
          str = stack.top() + str;
          stack.pop();
        }
        if (stack.top() == "[") {
          stack.pop();
        }
        string part;
        int n = nums.top();
        nums.pop();
        for (int i = 0; i < n; i++) {
          part += str;
        }
        stack.push(part);
      } else {
        stack.push(string(1, s[i]));
      }
    }
    string res;
    while (!stack.empty()) {
      res = stack.top() + res;
      stack.pop();
    }
    return res;
  }
};
// @lc code=end
