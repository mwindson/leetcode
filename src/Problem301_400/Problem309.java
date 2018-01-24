package Problem301_400;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class Problem309 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        // 第i天进行的动作
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] skip = new int[n];
        int[] hold = new int[n];
        buy[0] = 0 - prices[0];
        hold[0] = 0 - prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = skip[i - 1] - prices[i]; // 前一天skip才能卖
            hold[i] = Math.max(buy[i - 1], hold[i - 1]); // 前一天buy,或hold
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i]; // 前一天buy,或hold 才能卖
            skip[i] = Math.max(skip[i - 1], sell[i - 1]); // 前一天sell或skip
        }
        int max = 0;
        max = Math.max(buy[n - 1], max);
        max = Math.max(hold[n - 1], max);
        max = Math.max(skip[n - 1], max);
        max = Math.max(sell[n - 1], max);
        return max;
    }
}
