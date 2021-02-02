/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int buy = 0;
        int sell = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                maxProfit += prices[sell] - prices[buy];
                buy = i;
            }
            sell = i;
        }
        maxProfit += prices[sell] - prices[buy];
        return maxProfit;
    }
}
// @lc code=end
