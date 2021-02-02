/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // dp(k,i)=max{dp(k,i-1),prices[i]-prices[i-1]+dp(k-1,i-1)}
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 1; j <= k; j++) {
            dp[j][0] = 0;
            for (int i = 1; i < n; i++) {
                dp[j][i] = Math.max(dp[j][i - 1], prices[i] - prices[i - 1] + dp[j - 1][i - 1]);
            }
        }
        return dp[k][n - 1];
    }
}
// @lc code=end
