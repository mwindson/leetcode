/*
 * @lc app=leetcode id=204 lang=cpp
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Medium (33.01%)
 * Likes:    5332
 * Dislikes: 1067
 * Total Accepted:    638.5K
 * Total Submissions: 1.9M
 * Testcase Example:  '10'
 *
 * Given an integer n, return the number of prime numbers that are strictly
 * less than n.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 0
 * Output: 0
 *
 *
 * Example 3:
 *
 *
 * Input: n = 1
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= n <= 5 * 10^6
 *
 *
 */

// @lc code=start
class Solution {
public:
  int countPrimes(int n) {
    if (n <= 1) {
      return 0;
    }
    vector<int> isPrimes(n, true);
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrimes[i]) {
        count++;
        for (int j = i; j <= (n - 1) / i; j++) {
          isPrimes[i * j] = false;
        }
      }
    }
    return count;
  }
};
// @lc code=end
