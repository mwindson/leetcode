/*
 * @lc app=leetcode id=567 lang=cpp
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (44.50%)
 * Likes:    6401
 * Dislikes: 197
 * Total Accepted:    425.8K
 * Total Submissions: 962.1K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 *
 *
 * Example 1:
 *
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 *
 * Example 2:
 *
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s1.length, s2.length <= 10^4
 * s1 and s2 consist of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool checkInclusion(string s1, string s2) {
    if (s1.length() == 0) {
      return true;
    }
    unordered_map<char, int> cnt;
    for (char c : s1) {
      cnt[c]++;
    }
    int start = 0;
    int end = 0;
    auto map = cnt;
    while (end < s2.length()) {
      if (end - start >= s1.length()) {
        if (cnt.count(s2[start]) > 0) {
          map[s2[start]]++;
          if (map[s2[start]] == 0) {
            map.erase(s2[start]);
          }
        }
        start++;
      }
      if (cnt.count(s2[end]) > 0) {
        map[s2[end]]--;
        if (map[s2[end]] == 0) {
          map.erase(s2[end]);
        }
      }
      if (map.size() == 0) {
        return true;
      }
      end++;
    }
    return false;
  }
};
// @lc code=end
