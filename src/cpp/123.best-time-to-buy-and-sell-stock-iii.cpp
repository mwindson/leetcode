/*
 * @lc app=leetcode id=123 lang=cpp
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (43.42%)
 * Likes:    6747
 * Dislikes: 132
 * Total Accepted:    419.8K
 * Total Submissions: 946.3K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 *
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 *
 * Example 2:
 *
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 *
 *
 * Example 3:
 *
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 *
 *
 */

// @lc code=start
class Solution {
public:
  int maxProfit(vector<int> &prices) {
    int n = prices.size();
    if (n == 0) {
      return 0;
    }
    vector<int> stock(5, INT_MIN);
    vector<int> no_stock(5, INT_MIN);
    stock[1] = -prices[0];
    no_stock[0] = 0;
    int max_profit = 0;
    for (int i = 1; i < n; i++) {
      //  不动，买入或卖出
      for (int j = 4; j >= 1; j--) {
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
