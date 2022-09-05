/*
 * @lc app=leetcode id=188 lang=cpp
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (33.98%)
 * Likes:    4527
 * Dislikes: 163
 * Total Accepted:    271.7K
 * Total Submissions: 773.6K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * You are given an integer array prices where prices[i] is the price of a
 * given stock on the i^th day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 *
 *
 * Example 2:
 *
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3),
 * profit = 3-0 = 3.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 *
 *
 */

// @lc code=start
class Solution {
public:
  int maxProfit(int k, vector<int> &prices) {
    // 状态机
    // 每一天为状态为[是否持有股票, 已进行的交易次数]
    // 每次买入或卖出，交易次数+1;
    int n = prices.size();
    if (n == 0 || k == 0) {
      return 0;
    }
    vector<int> stock(2 * k + 1, INT_MIN);
    vector<int> no_stock(2 * k + 1, INT_MIN);
    stock[1] = -prices[0];
    no_stock[0] = 0;
    int max_profit = 0;
    for (int i = 1; i < n; i++) {
      //  不动，买入或卖出
      for (int j = 2 * k; j >= 1; j--) {
        if (no_stock[j - 1] != INT_MIN) {
          stock[j] = max(no_stock[j - 1] - prices[i], stock[j]);
        }
        if (stock[j - 1] != INT_MIN) {
          no_stock[j] = max(stock[j - 1] + prices[i], no_stock[j]);
        }
        if (i == n - 1) {
          max_profit = max(max_profit, max(stock[j], no_stock[j]));
        }
      }
    }
    return max_profit;
  }
};
// @lc code=end
