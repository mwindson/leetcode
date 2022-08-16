/*
 * @lc app=leetcode id=917 lang=cpp
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (61.09%)
 * Likes:    1555
 * Dislikes: 53
 * Total Accepted:    141.1K
 * Total Submissions: 230.3K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string s, reverse the string according to the following rules:
 *
 *
 * All the characters that are not English letters remain in the same
 * position.
 * All the English letters (lowercase or uppercase) should be reversed.
 *
 *
 * Return s after reversing it.
 *
 *
 * Example 1:
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 100
 * s consists of characters with ASCII values in the range [33, 122].
 * s does not contain '\"' or '\\'.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string reverseOnlyLetters(string s) {
    int l = 0;
    int h = s.length() - 1;
    while (l < h) {
      if (!isLetter(s[l])) {
        l++;
      }
      if (!isLetter(s[h])) {
        h--;
      }
      if (isLetter(s[l]) && isLetter(s[h])) {
        swap(s[l], s[h]);
        l++;
        h--;
      }
    }
    return s;
  }
  bool isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
};
// @lc code=end
