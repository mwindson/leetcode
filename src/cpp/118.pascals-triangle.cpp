/*
 * @lc app=leetcode id=118 lang=cpp
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (65.23%)
 * Likes:    7478
 * Dislikes: 247
 * Total Accepted:    960.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '5'
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 *
 * 1 <= numRows <= 30
 *
 *
 */

// @lc code=start
class Solution {
public:
  vector<vector<int>> generate(int numRows) {
    vector<vector<int>> ans;
    for (int row = 0; row < numRows; row++) {
      vector<int> layer(row + 1);
      for (int i = 0; i < row + 1; i++) {
        if (i == 0 || i == row) {
          layer[i] = 1;
        } else if (row >= 2) {
          layer[i] = ans[row - 1][i - 1] + ans[row - 1][i];
        }
      }
      ans.emplace_back(layer);
    }
    return ans;
  }
};
// @lc code=end
