/*
 * @lc app=leetcode id=84 lang=cpp
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (41.00%)
 * Likes:    10334
 * Dislikes: 149
 * Total Accepted:    521.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle
 * in the histogram.
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10
 * units.
 *
 *
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 *
 *
 */

// @lc code=start
class Solution {
public:
  int largestRectangleArea(vector<int> &heights) {
    int largest = 0;
    stack<int> stack; // 一个从大到小的栈
    heights.push_back(0); // 保证最终一定会空栈
    for (int i = 0; i < heights.size(); i++) {
      // 循环退栈，直到当前bar高度大于栈顶
      while (!stack.empty() && heights[stack.top()] >= heights[i]) {
        int h = heights[stack.top()];
        stack.pop();

        int left = stack.empty() ? -1 : stack.top();
        largest = max(largest, (i - left - 1) * h); // 当前栈顶是最小高度
      }
      stack.push(i);
    }

    return largest;
  }
};
// @lc code=end
