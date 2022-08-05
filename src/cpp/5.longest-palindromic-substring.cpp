/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (31.84%)
 * Likes:    19189
 * Dislikes: 1106
 * Total Accepted:    1.9M
 * Total Submissions: 6M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  string longestPalindrome(string s) {
    int n = s.length();
    int longest = 0;
    string res;
    if (n == 0) {
      return res;
    }
    vector<vector<bool>> dp(n, vector<bool>(n, false));
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }
    res = s.substr(0, 1);
    for (int len = 1; len < n; len++) {
      for (int i = 0; i + len < n; i++) {
        if (s[i] == s[i + len]) {
          if (len >= 2) {
            dp[i][i + len] = dp[i + 1][i + len - 1];
          } else {
            dp[i][i + len] = true;
          }
        }
        if (dp[i][i + len] && len > longest) {
          longest = len;
          res = s.substr(i, len + 1);
        }
      }
    }

    return res;
  }
};
// @lc code=end
