package Problem701_800;

/**
 * Best Time to Buy and Sell Stock with Transaction Fee
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * @ dp
 */
public class Problem714 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        // 第i天 进行的四种动作后的最大总额
        int[] buy = new int[n];
        int[] hold = new int[n]; // 持有stock时,skip
        int[] sell = new int[n];
        int[] skip = new int[n]; // 没有持有stock时,skip这天
        buy[0] = 0 - prices[0];
        hold[0] = 0 - prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(sell[i - 1], skip[i - 1]) - prices[i]; // 前一天sell或skip 才能买
            hold[i] = Math.max(buy[i - 1], hold[i - 1]); // 前一天buy,或hold
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i] - fee; // 前一天buy,或hold 才能卖
            skip[i] = Math.max(skip[i - 1], sell[i - 1]); // 前一天sell或skip
        }
        int max = 0;
        max = Math.max(buy[n - 1], max);
        max = Math.max(sell[n - 1], max);
        max = Math.max(hold[n - 1], max);
        max = Math.max(skip[n - 1], max);
        return max;
    }
}
