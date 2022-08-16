/*
 * @lc app=leetcode id=345 lang=cpp
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (47.06%)
 * Likes:    1791
 * Dislikes: 1952
 * Total Accepted:    371.9K
 * Total Submissions: 785.1K
 * Testcase Example:  '"hello"'
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
 * cases.
 *
 *
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 3 * 10^5
 * s consist of printable ASCII characters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string reverseVowels(string s) {
    int l = 0, h = s.length() - 1;
    while (l < h) {
      if (!isVowel(s[l])) {
        l++;
      }
      if (!isVowel(s[h])) {
        h--;
      }
      if (isVowel(s[l]) && isVowel(s[h])) {
        swap(s[l], s[h]);
        l++;
        h--;
      }
    }
    return s;
  }
  bool isVowel(char c) {
    set<char> vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
    return vowels.count(c) > 0;
  }
};
// @lc code=end
