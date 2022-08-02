/*
 * @lc app=leetcode id=120 lang=cpp
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (51.13%)
 * Likes:    6572
 * Dislikes: 431
 * Total Accepted:    504.3K
 * Total Submissions: 947.2K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 *
 *
 * Example 1:
 *
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * ⁠  2
 * ⁠ 3 4
 * ⁠6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
 * above).
 *
 *
 * Example 2:
 *
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 *
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the
 * total number of rows in the triangle?
 */

// @lc code=start
class Solution {
public:
  int minimumTotal(vector<vector<int>> &triangle) {
    vector<vector<int>> sum;
    for (int i = 0; i < triangle.size(); i++) {
      vector<int> sub_sum;
      for (int j = 0; j < triangle[i].size(); j++) {
        int prev = 0;
        if (i >= 1) {
          if (j == 0) {
            prev = sum[i - 1][j];
          } else if (j == triangle[i].size() - 1) {
            prev = sum[i - 1][j - 1];
          } else {
            prev = min(sum[i - 1][j - 1], sum[i - 1][j]);
          }
        }
        sub_sum.emplace_back(triangle[i][j] + prev);
      }
      sum.emplace_back(sub_sum);
    }
    int res = INT_MAX;
    for (int i = 0; i < sum[sum.size() - 1].size(); i++) {
      res = min(res, sum[sum.size() - 1][i]);
    }
    return res;
  }
};
// @lc code=end
