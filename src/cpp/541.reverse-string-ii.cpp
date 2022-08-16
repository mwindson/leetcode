/*
 * @lc app=leetcode id=541 lang=cpp
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (50.20%)
 * Likes:    1116
 * Dislikes: 2610
 * Total Accepted:    163.7K
 * Total Submissions: 325.7K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * Given a string s and an integer k, reverse the first k characters for every
 * 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the
 * first k characters and leave the other as original.
 *
 *
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^4
 *
 *
 */

// @lc code=start
class Solution {
public:
  string reverseStr(string s, int k) {
    int start = 0;
    while (start < s.length()) {
      reverse(s, start, min<int>(start + k - 1, s.length() - 1));
      start += 2 * k;
    }
    return s;
  }
  void reverse(string &s, int begin, int end) {
    while (begin < end) {
      swap(s[begin], s[end]);
      begin++;
      end--;
    }
  }
};
// @lc code=end
