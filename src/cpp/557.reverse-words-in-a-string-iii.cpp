/*
 * @lc app=leetcode id=557 lang=cpp
 *
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (79.09%)
 * Likes:    3165
 * Dislikes: 188
 * Total Accepted:    503.2K
 * Total Submissions: 630.6K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 *
 *
 * Example 1:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 5 * 10^4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string reverseWords(string s) {
    int begin = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s[i] == ' ') {
        if (begin >= 0) {
          reverse(s, begin, i - 1);
          begin = -1;
        }
      } else {
        if (begin == -1) {
          begin = i;
          continue;
        }
      }
    }
    if (begin >= 0) {
      reverse(s, begin, s.length() - 1);
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
