/*
 * @lc app=leetcode id=58 lang=cpp
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (38.11%)
 * Likes:    1532
 * Dislikes: 108
 * Total Accepted:    828.4K
 * Total Submissions: 2.1M
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int lengthOfLastWord(string s) {
    int len = 0;
    int start = -1;
    s = s + ' ';
    for (int i = 0; i < s.length(); i++) {
      char c = s[i];
      if (c == ' ') {
        if (start >= 0) {
          len = i - start;
          start = -1;
        }
      } else {
        if (start == -1) {
          start = i;
        }
      }
    }
    return len;
  }
};
// @lc code=end
