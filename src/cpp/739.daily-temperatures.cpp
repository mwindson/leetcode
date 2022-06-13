/*
 * @lc app=leetcode id=739 lang=cpp
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (67.32%)
 * Likes:    7202
 * Dislikes: 161
 * Total Accepted:    403.1K
 * Total Submissions: 598.6K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the i^th day to get a warmer temperature. If there is no future
 * day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 *
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<int> dailyTemperatures(vector<int> &temperatures) {
    stack<int> stack;
    vector<int> res(temperatures.size(), 0);
    for (int i = 0; i < temperatures.size(); i++) {
      while (!stack.empty() && temperatures[stack.top()] < temperatures[i]) {
        res[stack.top()] = i - stack.top();
        stack.pop();
      }
      stack.push(i);
    }
    // 无栈的方式
    for (int i = temperatures.size() - 1; i >= 0; --i) {
      int j = i + 1;
      while (j < temperatures.size() && temperatures[j] <= temperatures[i]) {
        if (res[j] > 0)
          j = res[j] + j;
        else
          j = temperatures.size();
      }
      // either j == size || temperatures[j] > temperatures[i]
      if (j < temperatures.size())
        res[i] = j - i;
    }
    return res;
  }
};
// @lc code=end
