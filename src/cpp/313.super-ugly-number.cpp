/*
 * @lc app=leetcode id=313 lang=cpp
 *
 * [313] Super Ugly Number
 *
 * https://leetcode.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (45.77%)
 * Likes:    1612
 * Dislikes: 304
 * Total Accepted:    108.5K
 * Total Submissions: 236.6K
 * Testcase Example:  '12\n[2,7,13,19]'
 *
 * A super ugly number is a positive integer whose prime factors are in the
 * array primes.
 *
 * Given an integer n and an array of integers primes, return the n^th super
 * ugly number.
 *
 * The n^th super ugly number is guaranteed to fit in a 32-bit signed
 * integer.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first
 * 12 super ugly numbers given primes = [2,7,13,19].
 *
 *
 * Example 2:
 *
 *
 * Input: n = 1, primes = [2,3,5]
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are
 * in the array primes = [2,3,5].
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10^5
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * primes[i] is guaranteed to be a prime number.
 * All the values of primes are unique and sorted in ascending order.
 *
 *
 */

// @lc code=start
class Solution {
public:
  int nthSuperUglyNumber(int n, vector<int> &primes) {
    vector<int> index(primes.size(), 0);
    vector<long> nums(n, LONG_MAX);
    nums[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < index.size(); j++) {
        nums[i] = min(nums[i], nums[index[j]] * primes[j]);
      }
      for (int j = 0; j < index.size(); j++) {
        if (nums[i] == nums[index[j]] * primes[j]) {
          index[j]++;
        }
      }
    }
    return nums[n - 1];
  }
};
// @lc code=end
