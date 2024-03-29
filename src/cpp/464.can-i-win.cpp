/*
 * @lc app=leetcode id=464 lang=cpp
 *
 * [464] Can I Win
 *
 * https://leetcode.com/problems/can-i-win/description/
 *
 * algorithms
 * Medium (29.84%)
 * Likes:    1977
 * Dislikes: 311
 * Total Accepted:    78.2K
 * Total Submissions: 262.1K
 * Testcase Example:  '10\n11'
 *
 * In the "100 game" two players take turns adding, to a running total, any
 * integer from 1 to 10. The player who first causes the running total to reach
 * or exceed 100 wins.
 *
 * What if we change the game so that players cannot re-use integers?
 *
 * For example, two players might take turns drawing from a common pool of
 * numbers from 1 to 15 without replacement until they reach a total >= 100.
 *
 * Given two integers maxChoosableInteger and desiredTotal, return true if the
 * first player to move can force a win, otherwise, return false. Assume both
 * players play optimally.
 *
 *
 * Example 1:
 *
 *
 * Input: maxChoosableInteger = 10, desiredTotal = 11
 * Output: false
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers
 * from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >=
 * desiredTotal.
 * Same with other integers chosen by the first player, the second player will
 * always win.
 *
 *
 * Example 2:
 *
 *
 * Input: maxChoosableInteger = 10, desiredTotal = 0
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: maxChoosableInteger = 10, desiredTotal = 1
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 *
 *
 */

// @lc code=start
class Solution {
public:
  bool canIWin(int maxChoosableInteger, int desiredTotal) {
    int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
    if (desiredTotal < 2) {
      return true;
    }
    if (sum < desiredTotal) {
      return false;
    }
    if (sum == desiredTotal) {
      return maxChoosableInteger % 2;
    }
    int mask = 0;
    vector<int> result(1 << 21, 0); // 1 win -1 lose
    return dfs(maxChoosableInteger, desiredTotal, mask, result);
  }
  bool dfs(int max, int total, int mask, vector<int> &result) {
    // memorized result
    if (result[mask] != 0) {
      return result[mask] > 0;
    }
    if (total <= 0) {
      return false;
    }
    for (int i = 1; i <= max; i++) {
      // try unused number and use this number will not let another play win
      if ((mask & (1 << i)) == 0 &&
          !dfs(max, total - i, mask | (1 << i), result)) {
        result[mask] = 1;
        return true;
      }
    }
    result[mask] = -1;
    return false;
  }
};
// @lc code=end
