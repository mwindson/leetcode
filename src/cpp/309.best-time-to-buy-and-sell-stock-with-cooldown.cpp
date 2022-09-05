/*
 * @lc app=leetcode id=309 lang=cpp
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (52.76%)
 * Likes:    6523
 * Dislikes: 225
 * Total Accepted:    315.9K
 * Total Submissions: 585.4K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 *
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 *
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 *
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 *
 * Example 2:
 *
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 *
 */

// @lc code=start
class Solution {
public:
  int maxProfit(vector<int> &prices) {
    int n = prices.size();
    if (n <= 1) {
      return 0;
    }
    // 状态机思想
    // 无股票且可买  buy   有股票
    // 有股票 sell 无股票且不可买
    // 无股票且不可买 cooldown 无股票且可买
    vector<int> stock(n, INT_MIN);    // 有股票的最大收益
    vector<int> no_stock(n, INT_MIN); // 无股票且可买的最大收益
    vector<int> cooldown(n, INT_MIN); // 无股票且不可买的最大收益
    stock[0] = -prices[0];
    no_stock[0] = 0;
    for (int i = 1; i < prices.size(); i++) {
      stock[i] = max(no_stock[i - 1] - prices[i], stock[i - 1]);
      no_stock[i] = max(no_stock[i - 1], cooldown[i - 1]);
      cooldown[i] = stock[i - 1] + prices[i];
    }
    return max(cooldown[n - 1], no_stock[n - 1]);
  }
};
// @lc code=end
