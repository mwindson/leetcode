/*
 * @lc app=leetcode id=984 lang=cpp
 *
 * [984] String Without AAA or BBB
 *
 * https://leetcode.com/problems/string-without-aaa-or-bbb/description/
 *
 * algorithms
 * Medium (42.52%)
 * Likes:    525
 * Dislikes: 335
 * Total Accepted:    35.5K
 * Total Submissions: 83.1K
 * Testcase Example:  '1\n2'
 *
 * Given two integers a and b, return any string s such that:
 *
 *
 * s has length a + b and contains exactly a 'a' letters, and exactly b 'b'
 * letters,
 * The substring 'aaa' does not occur in s, and
 * The substring 'bbb' does not occur in s.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: a = 1, b = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 *
 *
 * Example 2:
 *
 *
 * Input: a = 4, b = 1
 * Output: "aabaa"
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= a, b <= 100
 * It is guaranteed such an s exists for the given a and b.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string strWithout3a3b(int a, int b) {
    std::string res;

    while (a > 0 && b > 0) {
      if (a > b) {
        res += "aab";
        a--;
      } else if (b > a) {
        res += "bba";
        b--;
      } else {
        res += "ab";
      }
      a--;
      b--;
    }
    while (a--)
      res += "a";
    while (b--)
      res += "b";
    return res;
  }
};
// @lc code=end
