/*
 * @lc app=leetcode id=438 lang=cpp
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (48.39%)
 * Likes:    7705
 * Dislikes: 259
 * Total Accepted:    546.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 *
 * Example 2:
 *
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> findAnagrams(string s, string p) {
    vector<int> res;
    if (s.length() < p.length()) {
      return res;
    }
    unordered_map<char, int> char_map;
    for (char c : p) {
      char_map[c]++;
    }
    // 滑动窗口
    auto curr_map = char_map;
    int left = 0;
    int right = 0;
    while (right < p.length()) {
      curr_map[s[right]]--;
      if (curr_map[s[right]] == 0) {
        curr_map.erase(s[right]);
      }
      right++;
    }
    if (curr_map.empty()) {
      res.emplace_back(left);
    }
    while (right < s.length()) {
      curr_map[s[left]]++;
      curr_map[s[right]]--;
      cout << left << " " << right << " " << s[left] << " " << s[right] << endl;
      if (curr_map[s[left]] == 0) {
        curr_map.erase(s[left]);
      }
      if (curr_map[s[right]] == 0) {
        curr_map.erase(s[right]);
      }
      left++;
      right++;
      if (curr_map.empty()) {
        res.emplace_back(left);
      }
    }
    return res;
  }
};
// @lc code=end
