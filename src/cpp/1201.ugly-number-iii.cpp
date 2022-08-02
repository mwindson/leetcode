/*
 * @lc app=leetcode id=1201 lang=cpp
 *
 * [1201] Ugly Number III
 *
 * https://leetcode.com/problems/ugly-number-iii/description/
 *
 * algorithms
 * Medium (28.23%)
 * Likes:    849
 * Dislikes: 419
 * Total Accepted:    22.2K
 * Total Submissions: 77.9K
 * Testcase Example:  '3\n2\n3\n5'
 *
 * An ugly number is a positive integer that is divisible by a, b, or c.
 *
 * Given four integers n, a, b, and c, return the n^th ugly number.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3^rd is
 * 4.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4^th is
 * 6.
 *
 *
 * Example 3:
 *
 *
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5^th is
 * 10.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * It is guaranteed that the result will be in range [1, 2 * 10^9].
 *
 *
 */

// @lc code=start
class Solution {
public:
  int nthUglyNumber(int n, int A, int B, int C) {
    int lo = 1, hi = 2 * (int)1e9;
    long a = long(A), b = long(B), c = long(C);
    long ab = a * b / __gcd(a, b);
    long bc = b * c / __gcd(b, c);
    long ac = a * c / __gcd(a, c);
    long abc = a * bc / __gcd(a, bc);

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int cnt = mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac +
                mid / abc;
      if (cnt < n)
        lo = mid + 1;
      else
        // the condition: F(N) >= k
        hi = mid;
    }
    return lo;
  }
};
// @lc code=end
