package solutions.java;
/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if (n < 0) {
            return n == Integer.MIN_VALUE ? (1.0 / x) * (myPow(1.0 / x, -n - 1)) : myPow(1.0 / x, -n);
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, (n - 1) / 2);
    }
}
// @lc code=end
