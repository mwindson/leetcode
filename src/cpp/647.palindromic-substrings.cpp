/*
 * @lc app=leetcode id=647 lang=cpp
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (65.71%)
 * Likes:    7934
 * Dislikes: 171
 * Total Accepted:    497.1K
 * Total Submissions: 751.9K
 * Testcase Example:  '"abc"'
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int countSubstrings(string s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    vector<vector<bool>> dp(n, vector<bool>(n, false));
    int count = 0;
    for (int i = n - 1; i >= 0; i--) {
      dp[i][i] = true;
      count++;
      for (int j = i + 1; j < n; j++) {
        if (s[i] == s[j]) {
          dp[i][j] = j == i + 1 ? true : dp[i + 1][j - 1];
        }
        if (dp[i][j]) {
          count++;
        }
      }
    }
    return count;
  }
};
// @lc code=end
