package Problem101_200;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class Problem123 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }


    public static int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int k = 2;
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
}
