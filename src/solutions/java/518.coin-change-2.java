/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {
                dp[i] = dp[i] + (i - coin < 0 ? 0 : dp[i - coin]);
            }
        }
        return dp[amount];
    }
}
// @lc code=end
