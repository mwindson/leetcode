/*
 * @lc app=leetcode id=28 lang=cpp
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (36.18%)
 * Likes:    4804
 * Dislikes: 3876
 * Total Accepted:    1.4M
 * Total Submissions: 3.7M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 * Example 1:
 *
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int strStr(string haystack, string needle) {
    if (needle.empty()) {
      return 0;
    }
    if (haystack.length() < needle.length()) {
      return -1;
    }
    int index = -1;
    for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
      bool found = true;
      for (int j = 0; j < needle.length(); j++) {
        if (haystack[i + j] != needle[j]) {
          found = false;
          break;
        }
      }
      if (found) {
        index = i;
        break;
      }
    }
    return index;
  }
};
// @lc code=end
