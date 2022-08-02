/*
 * @lc app=leetcode id=859 lang=cpp
 *
 * [859] Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (28.79%)
 * Likes:    1509
 * Dislikes: 949
 * Total Accepted:    126.8K
 * Total Submissions: 438.8K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * Given two strings s and goal, return true if you can swap two letters in s
 * so the result is equal to goal, otherwise, return false.
 *
 * Swapping letters is defined as taking two indices i and j (0-indexed) such
 * that i != j and swapping the characters at s[i] and s[j].
 *
 *
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is
 * equal to goal.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b',
 * which results in "ba" != goal.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is
 * equal to goal.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length, goal.length <= 2 * 10^4
 * s and goal consist of lowercase letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool buddyStrings(string s, string goal) {
    if (s.length() != goal.length()) {
      return false;
    }
    vector<pair<char, char>> diffs;
    if (s == goal && set<char>(s.begin(), s.end()).size() < s.size()) {
      return true;
    }

    for (int i = 0; i < s.length(); i++) {
      if (s[i] != goal[i]) {
        diffs.emplace_back(make_pair(s[i], goal[i]));
        if (diffs.size() > 2) {
          return false;
        }
      }
    }
    return diffs.size() == 2 && diffs[0].first == diffs[1].second &&
           diffs[0].second == diffs[1].first;
  }
};
// @lc code=end
