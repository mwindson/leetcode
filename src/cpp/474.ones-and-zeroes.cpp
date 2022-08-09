/*
 * @lc app=leetcode id=474 lang=cpp
 *
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (46.51%)
 * Likes:    4237
 * Dislikes: 403
 * Total Accepted:    152.3K
 * Total Submissions: 326.4K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of
 * y.
 *
 *
 * Example 1:
 *
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10",
 * "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the
 * maximum of 3.
 *
 *
 * Example 2:
 *
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 *
 *
 */

// @lc code=start
class Solution {
public:
  int findMaxForm(vector<string> &strs, int m, int n) {
    //　 两个重量限制的01背包问题
    int size = strs.size();
    vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

    for (int i = 1; i <= size; i++) {
      auto zo = count(strs[i - 1]);
      int zero = zo.first;
      int one = zo.second;

      //
      for (int j = m; j >= zero; j--) {
        for (int k = n; k >= one; k--) {
          dp[j][k] = max(dp[j][k], dp[j - zero][k - one] + 1);
        }
      }
    }
    return dp[m][n];
  }
  pair<int, int> count(const string &str) {
    int zero = 0;
    int one = 0;
    for (char c : str) {
      if (c == '0') {
        zero++;
      } else if (c == '1') {
        one++;
      }
    }
    return make_pair(zero, one);
  }
};
// @lc code=end
