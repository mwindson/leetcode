/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // dp(k,i)=max{dp(k,i-1),prices[i]-prices[i-1]+dp(k-1,i-1)}
        int t = 2;
        int[][] dp = new int[t + 1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int k = 1; k <= t; k++) {
            dp[k][0] = 0;
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - prices[i - 1] + dp[k - 1][i - 1]);
            }
        }
        return dp[t][n - 1];
    }
}
// @lc code=end
