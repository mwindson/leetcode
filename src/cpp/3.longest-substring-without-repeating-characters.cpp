/*
 * @lc app=leetcode id=3 lang=cpp
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.15%)
 * Likes:    25636
 * Dislikes: 1112
 * Total Accepted:    3.5M
 * Total Submissions: 10.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    if (s.length() == 0) {
      return 0;
    }
    unordered_map<char, int> map;
    int left = 0;
    int max_len = 0;
    for (int i = 0; i < s.length(); i++) {
      if (map.count(s[i]) > 0 && map[s[i]] >= left) {
        left = map[s[i]] + 1;
      }
      map[s[i]] = i;
      max_len = max(max_len, i - left + 1);
    }
    return max_len;
  }
};
// @lc code=end
