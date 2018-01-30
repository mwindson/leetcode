package Problem101_200;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * @ tag dp
 */
public class Problem188 {
    public static void main(String[] args) {
        int k = 5;
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(k, prices));
    }

    //hold[i][k]  ith day k transaction have stock and maximum profit
    //unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
    public static int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) return maxP(prices);
        int[][] hold = new int[prices.length][k + 1];
        int[][] unhold = new int[prices.length][k + 1];
        hold[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) hold[i][0] = Math.max(hold[i - 1][0], -prices[i]);
        for (int j = 1; j <= k; j++) hold[0][j] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 买入时 transaction数不变
                hold[i][j] = Math.max(unhold[i - 1][j] - prices[i], hold[i - 1][j]);
                // 卖出时 transaction数 +1
                unhold[i][j] = Math.max(hold[i - 1][j - 1] + prices[i], unhold[i - 1][j]);
            }
        }
        return Math.max(hold[prices.length - 1][k], unhold[prices.length - 1][k]);
    }

    public static int maxP(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
